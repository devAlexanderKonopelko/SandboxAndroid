package com.konopelko.sandboxandroid.di.module.usecase

import com.konopelko.sandboxandroid.domain.usecase.getnews.GetAndroidNewsUseCase
import com.konopelko.sandboxandroid.domain.usecase.getnews.RealGetAndroidNewsUseCase
import org.koin.dsl.module

val koinModuleUseCase = module {

    single<GetAndroidNewsUseCase> {
        RealGetAndroidNewsUseCase(
            newsRepository = get()
        )
    }
}