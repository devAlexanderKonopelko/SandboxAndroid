package com.konopelko.sandboxandroid.di.module.network

import com.konopelko.sandboxandroid.BuildConfig
import com.konopelko.sandboxandroid.data.api.http.createApi
import com.konopelko.sandboxandroid.data.api.http.createHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val HTTP_CLIENT_BASE = "api.client.base"

val koinModuleNetwork = module {

    single(named(HTTP_CLIENT_BASE)) {
        createHttpClient()
    }

    single {
        createApi(
            httpClient = get(named(HTTP_CLIENT_BASE)),
            hostUrl = BuildConfig.NEWS_API_HOST
        )
    }
}