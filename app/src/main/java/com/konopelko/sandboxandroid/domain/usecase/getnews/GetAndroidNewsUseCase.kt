package com.konopelko.sandboxandroid.domain.usecase.getnews

import androidx.paging.PagingData
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import kotlinx.coroutines.flow.Flow

interface GetAndroidNewsUseCase {

    operator fun invoke(): Flow<PagingData<NewsResponse.Article>>
}