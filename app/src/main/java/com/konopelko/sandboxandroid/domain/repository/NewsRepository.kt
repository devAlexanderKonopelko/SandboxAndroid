package com.konopelko.sandboxandroid.domain.repository

import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import io.reactivex.rxjava3.core.Single


interface NewsRepository {

    fun getNews(keyWord: String): Single<NewsResponse>
}