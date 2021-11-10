package com.konopelko.sandboxandroid.utils.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.konopelko.sandboxandroid.utils.databinding.adapter.BindableAdapter

@BindingAdapter(value = ["data"])
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, data: T) {
    if (recyclerView.adapter is BindableAdapter<*>)
        (recyclerView.adapter as BindableAdapter<T>).setData(data)
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    url?.let {
        Glide.with(view.context).load(url).into(view)
    }
}

@BindingAdapter("isRefreshing")
fun setIsRefreshing(view: SwipeRefreshLayout, isRefreshing: Boolean) {
    view.isRefreshing = isRefreshing
}
