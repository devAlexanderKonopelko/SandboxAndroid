package com.konopelko.sandboxandroid.domain.usecase.getnews

import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import io.reactivex.rxjava3.core.Single

interface GetAndroidNewsUseCase {

    operator fun invoke(): Single<NewsResponse>
}