package com.konopelko.sandboxandroid.di.module

import com.konopelko.sandboxandroid.domain.repository.NewsRepository
import com.konopelko.sandboxandroid.domain.usecase.getnews.GetNewsUseCase
import com.konopelko.sandboxandroid.domain.usecase.getnews.RealGetNewsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    @Inject
    fun provide(newsRepository: NewsRepository): GetNewsUseCase =
        RealGetNewsUseCase(newsRepository)
}