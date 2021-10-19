package com.konopelko.sandboxandroid.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.konopelko.sandboxandroid.R
import com.konopelko.sandboxandroid.databinding.FragmentHomeBinding
import com.konopelko.sandboxandroid.presentation.adapter.news.NewsAdapter
import com.konopelko.sandboxandroid.presentation.adapter.news.comparator.NewsComparator
import com.konopelko.sandboxandroid.presentation.viewmodel.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    val viewModel: HomeViewModel by viewModel()

    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setupBinding()
        return binding!!.root
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
        binding?.homeSwipeRefreshLayout?.isRefreshing = false
        binding?.homeSwipeRefreshLayout?.setOnRefreshListener {
            viewModel.reloadNews()
        }
    }

    private fun setupBinding() {
        binding?.lifecycleOwner = viewLifecycleOwner
        binding?.viewmodel = viewModel
    }

    private fun setupRecyclerView() {
        newsRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        newsRecyclerView.adapter = NewsAdapter(NewsComparator) { article ->
            viewModel.onNewsClicked(article)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}