package com.konopelko.sandboxandroid.presentation.adapter.news

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.konopelko.sandboxandroid.R
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.databinding.ItemRecyclerArticleBinding
import com.konopelko.sandboxandroid.utils.databinding.adapter.BindableAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class NewsAdapter(
    diffCallback: DiffUtil.ItemCallback<NewsResponse.Article>,
    private val onNewsClickListener: (NewsResponse.Article) -> Unit
) : PagingDataAdapter<NewsResponse.Article, NewsViewHolder>(diffCallback),
    BindableAdapter<PagingData<NewsResponse.Article>> {

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
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun setData(data: PagingData<NewsResponse.Article>?) {
        Log.e("Adapter ", "setting data: $data")
        data?.let {
            CoroutineScope(Main).launch {
                submitData(it)
            }
        }
//        notifyDataSetChanged()
    }
}