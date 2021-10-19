package com.konopelko.sandboxandroid.data.repository

import com.konopelko.sandboxandroid.BuildConfig
import com.konopelko.sandboxandroid.data.api.NewsApi
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.domain.repository.NewsRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RealNewsRepository (
    private val api: NewsApi
): NewsRepository {

    override fun getNews(keyWord: String, page: Int): Single<NewsResponse> =
        api
            .getNews(prepareGetNewsParams(keyWord, page))
            .subscribeOn(Schedulers.io())

    private fun prepareGetNewsParams(keyWord: String, page: Int) = mapOf(
        "q" to keyWord,
        "page" to page.toString(),
        "apiKey" to BuildConfig.NEWS_APP_KEY
    )
}