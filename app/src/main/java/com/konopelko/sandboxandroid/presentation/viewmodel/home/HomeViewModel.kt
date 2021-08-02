package com.konopelko.sandboxandroid.presentation.viewmodel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.domain.usecase.getnews.GetAndroidNewsUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    getAndroidNews: GetAndroidNewsUseCase
): ViewModel() {

    val articles: MutableLiveData<List<NewsResponse.Article>> by lazy {
        MutableLiveData<List<NewsResponse.Article>>()
    }

    init {
        getAndroidNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                       articles.value = it.articles
            },{
                //
            })
    }
}