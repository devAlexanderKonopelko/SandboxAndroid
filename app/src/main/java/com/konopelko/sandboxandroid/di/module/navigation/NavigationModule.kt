package com.konopelko.sandboxandroid.di.module.navigation

import dagger.Module
import dagger.Provides
import okhttp3.Route
import ru.terrakok.cicerone.BaseRouter
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Inject
import javax.inject.Singleton

@Module
class NavigationModule {

    @Singleton
    @Provides
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @Singleton
    @Provides
    @Inject
    fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router

    @Singleton
    @Provides
    @Inject
    fun provideNavigationHolder(cicerone: Cicerone<Router>): NavigatorHolder = cicerone.navigatorHolder
}