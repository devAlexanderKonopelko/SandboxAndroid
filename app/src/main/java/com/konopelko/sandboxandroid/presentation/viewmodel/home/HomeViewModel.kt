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

    val articles = MutableLiveData<List<NewsResponse.Article>>()

    var lifecycleOwner: LifecycleOwner? = null

    private val subscriptions = mutableListOf<Disposable>()

    private val lifecycleObserver = object : DefaultLifecycleObserver {
        override fun onDestroy(owner: LifecycleOwner) {
            Log.e("Rx ", "disposing subscriptions")
            subscriptions.forEach {
                it.dispose()
            }
            super.onDestroy(owner)
        }
    }

    init {
        lifecycleOwner?.lifecycle?.addObserver(lifecycleObserver)
        getAndroidNews()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                articles.value = it.articles
            }, {
                Log.e("News ", "error")
                it.printStackTrace()
            }).addToSubscriptions(subscriptions)
    }
}