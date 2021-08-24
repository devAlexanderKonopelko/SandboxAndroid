package com.konopelko.sandboxandroid.domain.usecase.getnews

import androidx.paging.PagingData
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import io.reactivex.rxjava3.core.Observable

interface GetAndroidNewsUseCase {

    operator fun invoke(): Observable<PagingData<NewsResponse.Article>>
}