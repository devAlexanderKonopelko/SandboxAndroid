package com.konopelko.sandboxandroid.utils.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.konopelko.sandboxandroid.utils.databinding.adapter.BindableAdapter

@BindingAdapter("data")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, data: T) {
    if (recyclerView.adapter is BindableAdapter<*>)
            (recyclerView.adapter as BindableAdapter<T>).setData(data)
}