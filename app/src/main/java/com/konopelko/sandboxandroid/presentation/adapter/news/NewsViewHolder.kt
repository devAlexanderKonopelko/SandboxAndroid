package com.konopelko.sandboxandroid.presentation.adapter.news

import androidx.recyclerview.widget.RecyclerView
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.databinding.ItemRecyclerArticleBinding

class NewsViewHolder(private val binding: ItemRecyclerArticleBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(article: NewsResponse.Article) {
        binding.article = article
        binding.executePendingBindings()
    }
}