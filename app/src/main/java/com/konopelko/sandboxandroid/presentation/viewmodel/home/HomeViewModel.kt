package com.konopelko.sandboxandroid.presentation.viewmodel.home

import android.util.Log
import androidx.lifecycle.*
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.domain.usecase.getnews.GetAndroidNewsUseCase
import com.konopelko.sandboxandroid.utils.disposable.addToSubscriptions
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    getAndroidNews: GetAndroidNewsUseCase
) : ViewModel() {

    private val _articles = MutableLiveData<List<NewsResponse.Article>>()
    val articles: LiveData<List<NewsResponse.Article>> = _articles

    private val _dataIsLoading = MutableLiveData<Boolean>()
    val dataIsLoading: LiveData<Boolean> = _dataIsLoading

    private val subscriptions = mutableListOf<Disposable>()

    init {
        _dataIsLoading.value = true
        getAndroidNews()
            .subscribe({
                _dataIsLoading.postValue(false)
                _articles.postValue(it.articles)
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
}