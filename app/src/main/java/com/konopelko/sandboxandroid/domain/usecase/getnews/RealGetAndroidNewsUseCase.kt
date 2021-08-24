package com.konopelko.sandboxandroid.domain.usecase.getnews

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava3.observable
import com.konopelko.sandboxandroid.data.api.ApiConstants
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.data.source.NewsPagingSource
import com.konopelko.sandboxandroid.domain.repository.NewsRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class RealGetAndroidNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) : GetAndroidNewsUseCase {

    @ExperimentalCoroutinesApi
    override fun invoke(): Observable<PagingData<NewsResponse.Article>> =
        Pager(PagingConfig(
            pageSize = 20
        )) {
            Log.e("UseCase ", "pager invoked.")
            NewsPagingSource(newsRepository, ApiConstants.KEY_WORD_ANDROID)
        }.observable

}