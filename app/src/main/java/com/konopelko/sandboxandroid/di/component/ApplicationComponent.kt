package com.konopelko.sandboxandroid.di.component

import com.konopelko.sandboxandroid.di.module.network.NetworkModule
import com.konopelko.sandboxandroid.di.module.repository.RepositoryModule
import com.konopelko.sandboxandroid.di.module.usecase.UseCaseModule
import com.konopelko.sandboxandroid.presentation.view.details.DetailsFragment
import com.konopelko.sandboxandroid.presentation.view.home.HomeActivity
import com.konopelko.sandboxandroid.presentation.view.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, UseCaseModule::class, RepositoryModule::class])
interface ApplicationComponent {

    fun inject(activity: HomeActivity)

    fun inject(fragment: HomeFragment)

    fun inject(fragment: DetailsFragment)
}