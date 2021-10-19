package com.konopelko.sandboxandroid.domain.usecase.getnews

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.konopelko.sandboxandroid.data.api.ApiConstants
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.data.source.NewsPagingSource
import com.konopelko.sandboxandroid.domain.repository.NewsRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

class RealGetAndroidNewsUseCase(
    private val newsRepository: NewsRepository
) : GetAndroidNewsUseCase {

    @ExperimentalCoroutinesApi
    override fun invoke(): Flow<PagingData<NewsResponse.Article>> =
        Pager(
            PagingConfig(
                pageSize = 20
            )
        ) {
            Log.e("UseCase ", "pager invoked.")
            NewsPagingSource(newsRepository, ApiConstants.KEY_WORD_ANDROID)
        }.flow

}