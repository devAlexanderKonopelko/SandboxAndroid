package com.konopelko.sandboxandroid.domain.usecase.getnews

import com.konopelko.sandboxandroid.data.api.ApiConstants
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.domain.repository.NewsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RealGetAndroidNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
): GetAndroidNewsUseCase {

    override fun invoke(): Single<NewsResponse> =
        newsRepository.getNews(ApiConstants.KEY_WORD_ANDROID)
}