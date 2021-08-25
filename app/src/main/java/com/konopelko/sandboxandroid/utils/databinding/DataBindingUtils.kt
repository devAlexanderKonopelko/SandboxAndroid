package com.konopelko.sandboxandroid.utils.databinding

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.konopelko.sandboxandroid.utils.databinding.adapter.BindableAdapter

@BindingAdapter(value = ["data"])
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, data: T) {
    Log.e("Binding ", "data: $data")
    if (recyclerView.adapter is BindableAdapter<*>)
        (recyclerView.adapter as BindableAdapter<T>).setData(data)
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty())
        Glide.with(view.context).load(url).into(view)
}

@BindingAdapter("isRefreshing")
fun setIsRefreshing(view: SwipeRefreshLayout, isRefreshing: Boolean) {
    view.isRefreshing = isRefreshing
}
