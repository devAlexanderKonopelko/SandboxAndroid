package com.konopelko.sandboxandroid.data.api.http

import com.konopelko.sandboxandroid.data.api.NewsApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun createApi(
    httpClient: OkHttpClient,
    hostUrl: String
): NewsApi =
    Retrofit
        .Builder()
        .baseUrl(hostUrl)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
        .create(NewsApi::class.java)