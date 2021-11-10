package com.konopelko.sandboxandroid.presentation.view.details

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.konopelko.sandboxandroid.SandboxAndroidApplication
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.databinding.FragmentDetailsBinding
import com.konopelko.sandboxandroid.presentation.viewmodel.details.DetailsViewModel
import javax.inject.Inject

class DetailsFragment : Fragment() {

    @Inject
    lateinit var viewModel: DetailsViewModel

    private val binding: FragmentDetailsBinding by lazy {
        FragmentDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setArticle(arguments)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as SandboxAndroidApplication).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setupBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTransparentStatusBar()
        setupToolbarPaddings()

        viewModel.getIsReadArticleClicked().observe(viewLifecycleOwner) {
            if (it) openArticleInBrowser()
        }
    }

    private fun setupToolbarPaddings() {
        ViewCompat.setOnApplyWindowInsetsListener(binding?.detailAppBarLayout!!) { v, insets ->
            binding.detailAppBarLayout.setPadding(0, 0, 0, 0)
            WindowInsetsCompat.CONSUMED
        }
    }

    private fun setupTransparentStatusBar() {
        requireActivity().window.statusBarColor = Color.TRANSPARENT
    }

    private fun openArticleInBrowser() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(viewModel.getArticle().value?.url))
        startActivity(intent)
    }

    private fun setupBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }

    companion object {

        private const val KEY_ARTICLE = "key.article"

        fun newInstance(article: NewsResponse.Article): DetailsFragment =
            DetailsFragment().apply {
                val args = bundleOf(
                    KEY_ARTICLE to article
                )
                this.arguments = args
            }
    }
}