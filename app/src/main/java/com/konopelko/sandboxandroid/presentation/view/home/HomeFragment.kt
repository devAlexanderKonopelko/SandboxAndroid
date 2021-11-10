package com.konopelko.sandboxandroid.presentation.view.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.konopelko.sandboxandroid.R
import com.konopelko.sandboxandroid.SandboxAndroidApplication
import com.konopelko.sandboxandroid.databinding.FragmentHomeBinding
import com.konopelko.sandboxandroid.presentation.adapter.news.NewsAdapter
import com.konopelko.sandboxandroid.presentation.adapter.news.comparator.NewsComparator
import com.konopelko.sandboxandroid.presentation.viewmodel.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModel: HomeViewModel

    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
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
        setupStatusBarColor()

        setupRecyclerView()
        setupSwipeRefreshLayout()
        viewModel.setupLifecycleOwner(viewLifecycleOwner)
    }

    private fun setupStatusBarColor() {
        requireActivity().window.statusBarColor = ResourcesCompat.getColor(resources, R.color.purple_500, null)
    }

    private fun setupSwipeRefreshLayout() {
        binding.homeSwipeRefreshLayout.isRefreshing = false
        binding.homeSwipeRefreshLayout.setOnRefreshListener {
            viewModel.reloadNews()
        }
    }

    private fun setupBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModel
    }

    private fun setupRecyclerView() {
        newsRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        newsRecyclerView.adapter = NewsAdapter(NewsComparator) { article ->
            viewModel.onNewsClicked(article)
        }
    }
}