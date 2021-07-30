package com.konopelko.sandboxandroid.di.module

import com.konopelko.sandboxandroid.data.api.NewsApi
import com.konopelko.sandboxandroid.data.repository.RealNewsRepository
import com.konopelko.sandboxandroid.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    @Inject
    fun provide(api: NewsApi): NewsRepository =
        RealNewsRepository(api)
}