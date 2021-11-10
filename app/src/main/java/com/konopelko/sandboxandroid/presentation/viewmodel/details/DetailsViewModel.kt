package com.konopelko.sandboxandroid.presentation.viewmodel.details

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import ru.terrakok.cicerone.Router

class DetailsViewModel(
    private val router: Router
) : ViewModel() {

    private val article = MutableLiveData<NewsResponse.Article>()
    private val isReadArticleClicked = MutableLiveData<Boolean>()

    fun onArticleClicked() {
        isReadArticleClicked.value = true
    }

    fun onBackClicked() {
        router.exit()
    }

    fun setArticle(arguments: Bundle?) {
        arguments?.let {
            this.article.value = it.getParcelable(KEY_ARTICLE)
        }
    }

    fun getArticle(): LiveData<NewsResponse.Article> = article

    fun getIsReadArticleClicked(): LiveData<Boolean> = isReadArticleClicked

    companion object {

        private const val KEY_ARTICLE = "key.article"
    }
}