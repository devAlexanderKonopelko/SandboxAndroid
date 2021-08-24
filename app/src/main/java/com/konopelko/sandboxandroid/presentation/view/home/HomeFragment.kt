package com.konopelko.sandboxandroid.presentation.view.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.LinearLayoutManager
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

    private var binding: FragmentHomeBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as SandboxAndroidApplication).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setupBinding()
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupSwipeRefreshLayout()
        viewModel.setupLifecycleOwner(viewLifecycleOwner)
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