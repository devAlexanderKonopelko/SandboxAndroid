package com.konopelko.sandboxandroid.presentation.adapter.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.konopelko.sandboxandroid.R
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.utils.databinding.adapter.BindableAdapter

class NewsAdapter : RecyclerView.Adapter<NewsViewHolder>(), BindableAdapter<List<NewsResponse.Article>> {

    private var articles = listOf<NewsResponse.Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_article, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int = articles.size

    override fun setData(data: List<NewsResponse.Article>?) {
        articles = data ?: listOf()
        notifyDataSetChanged()
    }
}