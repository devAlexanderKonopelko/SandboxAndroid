package com.konopelko.sandboxandroid.data.api

import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @QueryMap params: Map<String, String>
    ): Response<NewsResponse>
}