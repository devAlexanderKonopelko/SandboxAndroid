package com.konopelko.sandboxandroid

import android.app.Application
import com.konopelko.sandboxandroid.di.module.navigation.koinModuleNavigation
import com.konopelko.sandboxandroid.di.module.network.koinModuleNetwork
import com.konopelko.sandboxandroid.di.module.repository.koinModuleRepository
import com.konopelko.sandboxandroid.di.module.usecase.koinModuleUseCase
import com.konopelko.sandboxandroid.di.module.viewmodel.koinModuleViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SandboxAndroidApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SandboxAndroidApplication)
            modules(
                koinModuleNetwork,
                koinModuleRepository,
                koinModuleUseCase,
                koinModuleNavigation,
                koinModuleViewModel
            )
        }
    }
}