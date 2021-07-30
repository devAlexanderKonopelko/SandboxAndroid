package com.konopelko.sandboxandroid.di.module

import com.konopelko.sandboxandroid.BuildConfig
import com.konopelko.sandboxandroid.data.api.NewsApi
import com.konopelko.sandboxandroid.data.api.http.createApi
import com.konopelko.sandboxandroid.data.api.http.createHttpClient
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Inject

@Module
class NetworkModule {

    @Provides
    fun provideHttpClient(): OkHttpClient = createHttpClient()

    @Provides
    @Inject
    fun provideApi(httpClient: OkHttpClient): NewsApi =
        createApi(
            httpClient,
            BuildConfig.NEWS_API_HOST
        )
}