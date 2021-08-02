package com.konopelko.sandboxandroid.presentation.viewmodel.home

import android.util.Log
import androidx.lifecycle.*
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.domain.usecase.getnews.GetAndroidNewsUseCase
import com.konopelko.sandboxandroid.utils.disposable.addToSubscriptions
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    getAndroidNews: GetAndroidNewsUseCase
) : ViewModel() {

    private val articles = MutableLiveData<List<NewsResponse.Article>>()
    private val dataIsLoading = MutableLiveData<Boolean>()

    private val subscriptions = mutableListOf<Disposable>()

    init {
        dataIsLoading.value = true
        getAndroidNews()
            .subscribe({
                dataIsLoading.postValue(false)
                articles.postValue(it.articles)
            }, {
                Log.e("News ", "error")
                it.printStackTrace()
            })
            .addToSubscriptions(subscriptions)
    }

    private val lifecycleObserver = object : DefaultLifecycleObserver {
        override fun onDestroy(owner: LifecycleOwner) {
            Log.e("Rx ", "disposing subscriptions")
            subscriptions.forEach {
                it.dispose()
            }
            super.onDestroy(owner)
        }
    }

    fun setupLifecycleOwner(viewLifecycleOwner: LifecycleOwner) {
        viewLifecycleOwner.lifecycle.addObserver(lifecycleObserver)
    }

    fun getArticles(): LiveData<List<NewsResponse.Article>> = articles

    fun getDataIsLoading(): LiveData<Boolean> = dataIsLoading
}