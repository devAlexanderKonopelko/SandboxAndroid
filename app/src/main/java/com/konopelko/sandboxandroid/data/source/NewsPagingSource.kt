package com.konopelko.sandboxandroid.data.source


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.domain.repository.NewsRepository
import io.reactivex.rxjava3.core.Single
import retrofit2.HttpException
import java.io.IOException

class NewsPagingSource(
    private val repository: NewsRepository,
    private val keyWord: String
) : PagingSource<Int, NewsResponse.Article>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsResponse.Article> {
        val nextPageNumber = params.key ?: 1

        return try {
            val apiResult = repository.getNews(keyWord, nextPageNumber)

            LoadResult.Page(
                apiResult.articles,
                prevKey = null,
                nextKey = nextPageNumber + 1
            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, NewsResponse.Article>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
}