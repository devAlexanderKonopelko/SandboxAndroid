package com.konopelko.sandboxandroid.data.api

import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    fun getNews(@Query("q") keyWord: String, @Query("apiKey") apiKey: String): Single<NewsResponse>
}