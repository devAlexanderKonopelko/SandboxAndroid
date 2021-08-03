package com.konopelko.sandboxandroid.presentation.adapter.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.konopelko.sandboxandroid.R
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.databinding.ItemRecyclerArticleBinding
import com.konopelko.sandboxandroid.utils.databinding.adapter.BindableAdapter

class NewsAdapter(
    private val onNewsClickListener: (NewsResponse.Article) -> Unit
) : RecyclerView.Adapter<NewsViewHolder>(),
    BindableAdapter<List<NewsResponse.Article>> {

    private var articles = listOf<NewsResponse.Article>()

    fun onNewsClicked(news: NewsResponse.Article) = onNewsClickListener(news)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemRecyclerArticleBinding>(
            inflater,
            R.layout.item_recycler_article,
            parent,
            false
        )
        return NewsViewHolder(binding, this)
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