package com.konopelko.sandboxandroid.presentation.viewmodel.home

import android.util.Log
import androidx.lifecycle.*
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.domain.usecase.getnews.GetAndroidNewsUseCase
import com.konopelko.sandboxandroid.presentation.navigation.Screens
import com.konopelko.sandboxandroid.utils.disposable.addToSubscriptions
import io.reactivex.rxjava3.disposables.Disposable
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getAndroidNews: GetAndroidNewsUseCase,
    private val router: Router
) : ViewModel() {

    private val articles = MutableLiveData<List<NewsResponse.Article>>()
    private val isDataLoading = MutableLiveData<Boolean>()
    private val isDataReLoading = MutableLiveData<Boolean>()

    private val subscriptions = mutableListOf<Disposable>()

    init {
        isDataLoading.value = true
        loadNews()
    }

    private fun loadNews() {
        getAndroidNews()
            .subscribe({
                isDataReLoading.postValue(false)
                isDataLoading.postValue(false)
                articles.postValue(it.articles)
            }, {
                Log.e("News ", "error")
                it.printStackTrace()
            })
            .addToSubscriptions(subscriptions)
    }

    fun reloadNews() {
        isDataReLoading.value = true
        loadNews()
    }

    fun onNewsClicked(news: NewsResponse.Article) {
        val screen = Screens.DetailsScreen(news)
        router.navigateTo(screen)
    }

    private val lifecycleObserver = object : DefaultLifecycleObserver {
        override fun onDestroy(owner: LifecycleOwner) {
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

    fun getIsDataLoading(): LiveData<Boolean> = isDataLoading

    fun getIsDataReLoading(): LiveData<Boolean> = isDataReLoading
}