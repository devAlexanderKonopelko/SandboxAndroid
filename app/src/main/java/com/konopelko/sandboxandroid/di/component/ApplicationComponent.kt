package com.konopelko.sandboxandroid.di.component

import com.konopelko.sandboxandroid.di.module.NetworkModule
import com.konopelko.sandboxandroid.presentation.view.home.HomeActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(activity: HomeActivity)
}