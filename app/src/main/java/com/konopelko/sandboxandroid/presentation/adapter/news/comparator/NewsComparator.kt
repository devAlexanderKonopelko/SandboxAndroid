package com.konopelko.sandboxandroid.presentation.adapter.news.comparator

import androidx.recyclerview.widget.DiffUtil
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse

object NewsComparator: DiffUtil.ItemCallback<NewsResponse.Article>() {

    override fun areItemsTheSame(
        oldItem: NewsResponse.Article,
        newItem: NewsResponse.Article
    ): Boolean = oldItem == newItem


    override fun areContentsTheSame(
        oldItem: NewsResponse.Article,
        newItem: NewsResponse.Article
    ): Boolean = oldItem == newItem

}