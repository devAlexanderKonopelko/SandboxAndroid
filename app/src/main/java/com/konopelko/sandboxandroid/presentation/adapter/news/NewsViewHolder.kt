package com.konopelko.sandboxandroid.presentation.adapter.news

import androidx.recyclerview.widget.RecyclerView
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.databinding.ItemRecyclerArticleBinding

class NewsViewHolder(
    private val binding: ItemRecyclerArticleBinding,
    adapter: NewsAdapter
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.adapter = adapter
    }

    fun bind(article: NewsResponse.Article) {
        binding.article = article
        binding.executePendingBindings()
    }
}