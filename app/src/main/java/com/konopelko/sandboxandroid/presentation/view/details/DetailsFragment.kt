package com.konopelko.sandboxandroid.presentation.view.details

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
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.databinding.FragmentDetailsBinding
import com.konopelko.sandboxandroid.presentation.viewmodel.details.DetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {

    val viewModel: DetailsViewModel by viewModel()

    private var binding: FragmentDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setArticle(arguments?.getParcelable(KEY_ARTICLE)!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        setupBinding()
        return binding!!.root
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
            binding?.detailAppBarLayout!!.setPadding(0, 0, 0, 0)
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
        binding?.lifecycleOwner = viewLifecycleOwner
        binding?.viewModel = viewModel
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