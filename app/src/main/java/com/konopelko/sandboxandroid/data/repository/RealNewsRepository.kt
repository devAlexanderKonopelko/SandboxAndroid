package com.konopelko.sandboxandroid.data.repository

import com.konopelko.sandboxandroid.data.api.NewsApi
import com.konopelko.sandboxandroid.domain.repository.NewsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RealNewsRepository @Inject constructor(
    private val api: NewsApi
): NewsRepository {


}