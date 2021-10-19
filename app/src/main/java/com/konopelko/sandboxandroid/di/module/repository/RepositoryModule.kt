package com.konopelko.sandboxandroid.di.module.repository

import com.konopelko.sandboxandroid.data.repository.RealNewsRepository
import com.konopelko.sandboxandroid.domain.repository.NewsRepository
import org.koin.dsl.module

val koinModuleRepository = module {

    single<NewsRepository> {
        RealNewsRepository(
            api = get()
        )
    }
}