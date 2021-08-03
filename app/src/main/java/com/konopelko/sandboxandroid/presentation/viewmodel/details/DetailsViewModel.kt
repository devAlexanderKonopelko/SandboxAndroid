package com.konopelko.sandboxandroid.presentation.viewmodel.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val router: Router
) : ViewModel() {

    private val article = MutableLiveData<NewsResponse.Article>()

    fun onArticleClicked() {
        Log.e("Article ", "read clicked")
    }

    fun onBackClicked() {
        router.exit()
    }

    fun setArticle(article: NewsResponse.Article) {
        this.article.value = article
    }

    fun getArticle(): LiveData<NewsResponse.Article> = article
}