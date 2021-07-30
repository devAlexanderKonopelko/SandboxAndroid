package com.konopelko.sandboxandroid.data.repository

import com.konopelko.sandboxandroid.BuildConfig
import com.konopelko.sandboxandroid.data.api.NewsApi
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.domain.repository.NewsRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RealNewsRepository @Inject constructor(
    private val api: NewsApi
): NewsRepository {

    override fun getNews(keyWord: String): Single<NewsResponse> =
        api
            .getNews(keyWord, BuildConfig.NEWS_APP_KEY)
            .subscribeOn(Schedulers.io())
}