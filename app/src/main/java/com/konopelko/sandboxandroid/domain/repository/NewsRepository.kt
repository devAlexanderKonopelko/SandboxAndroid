package com.konopelko.sandboxandroid.domain.repository

import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse


interface NewsRepository {

    suspend fun getNews(keyWord: String, page: Int): NewsResponse
}