package com.konopelko.sandboxandroid.utils.databinding.adapter

import androidx.lifecycle.Lifecycle

interface BindableAdapter<T> {

    fun setData(data: T?)
}