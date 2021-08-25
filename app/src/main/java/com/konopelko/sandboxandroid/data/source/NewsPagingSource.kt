package com.konopelko.sandboxandroid.data.source


import android.util.Log
import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.domain.repository.NewsRepository
import io.reactivex.rxjava3.core.Single

class NewsPagingSource(
    private val repository: NewsRepository,
    private val keyWord: String
): RxPagingSource<Int, NewsResponse.Article>() {

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, NewsResponse.Article>> {
        Log.e("Source ", "loadSingle()")
        val nextPageNumber = params.key ?: 1

        return repository.getNews(keyWord, nextPageNumber)
            .map {
                LoadResult.Page(
                    it.articles,
                    prevKey = null,
                    nextKey = nextPageNumber + 1
                )
            }
    }

    override fun getRefreshKey(state: PagingState<Int, NewsResponse.Article>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
}