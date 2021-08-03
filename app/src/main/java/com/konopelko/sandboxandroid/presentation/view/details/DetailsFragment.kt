package com.konopelko.sandboxandroid.presentation.view.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.konopelko.sandboxandroid.SandboxAndroidApplication
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.databinding.FragmentDetailsBinding
import com.konopelko.sandboxandroid.databinding.FragmentHomeBinding
import com.konopelko.sandboxandroid.presentation.viewmodel.details.DetailsViewModel
import javax.inject.Inject

class DetailsFragment: Fragment() {

    @Inject
    lateinit var viewModel: DetailsViewModel

    private var binding: FragmentDetailsBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as SandboxAndroidApplication).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        setupBinding()
        return binding!!.root
    }

    private fun setupBinding() {
        binding?.lifecycleOwner = viewLifecycleOwner
//        binding?.viewmodel = viewModel
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