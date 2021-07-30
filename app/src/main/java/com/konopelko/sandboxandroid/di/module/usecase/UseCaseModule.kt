package com.konopelko.sandboxandroid.di.module.usecase

import com.konopelko.sandboxandroid.domain.repository.NewsRepository
import com.konopelko.sandboxandroid.domain.usecase.getnews.GetAndroidNewsUseCase
import com.konopelko.sandboxandroid.domain.usecase.getnews.RealGetAndroidNewsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    @Inject
    fun provide(newsRepository: NewsRepository): GetAndroidNewsUseCase =
        RealGetAndroidNewsUseCase(newsRepository)
}