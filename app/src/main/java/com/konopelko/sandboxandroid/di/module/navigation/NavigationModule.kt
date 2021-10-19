package com.konopelko.sandboxandroid.di.module.navigation

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

private const val CICERONE_ROUTER = "cicerone.router"

val koinModuleNavigation = module {

    single<Cicerone<Router>>(named(CICERONE_ROUTER)) {
        Cicerone.create()
    }

    single {
        provideRouter(get(named(CICERONE_ROUTER)))
    }

    single {
        provideNavigationHolder(get(named(CICERONE_ROUTER)))
    }
}

private fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router

private fun provideNavigationHolder(cicerone: Cicerone<Router>): NavigatorHolder =
    cicerone.navigatorHolder