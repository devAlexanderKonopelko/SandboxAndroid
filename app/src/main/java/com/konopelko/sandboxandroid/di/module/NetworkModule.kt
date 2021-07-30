package com.konopelko.sandboxandroid.di.module

import com.konopelko.sandboxandroid.BuildConfig
import com.konopelko.sandboxandroid.data.api.NewsApi
import com.konopelko.sandboxandroid.data.api.http.createApi
import com.konopelko.sandboxandroid.data.api.http.createHttpClient
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Inject
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient = createHttpClient()

    @Singleton
    @Provides
    @Inject
    fun provideApi(httpClient: OkHttpClient): NewsApi =
        createApi(
            httpClient,
            BuildConfig.NEWS_API_HOST
        )
}