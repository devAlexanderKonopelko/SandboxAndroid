package com.konopelko.sandboxandroid.presentation.adapter.news

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import kotlinx.android.synthetic.main.item_recycler_article.view.*

class NewsViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    fun bind(article: NewsResponse.Article) {
        view.articleItemHeadline.text = article.title
        view.articleItemAuthor.text = article.author
        view.articleItemDate.text = article.publishedAt
        view.articleItemText.text = article.description
    }
}