package com.konopelko.sandboxandroid.di.module.viewmodel

import com.konopelko.sandboxandroid.presentation.viewmodel.details.DetailsViewModel
import com.konopelko.sandboxandroid.presentation.viewmodel.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val koinModuleViewModel = module {


    viewModel {
        HomeViewModel(
            getAndroidNews = get(),
            router = get()
        )
    }

    viewModel {
        DetailsViewModel(
            router = get()
        )
    }
}