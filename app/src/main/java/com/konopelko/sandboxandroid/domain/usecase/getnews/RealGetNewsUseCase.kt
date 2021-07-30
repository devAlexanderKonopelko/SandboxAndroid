package com.konopelko.sandboxandroid.domain.usecase.getnews

import com.konopelko.sandboxandroid.domain.repository.NewsRepository
import javax.inject.Inject
import javax.inject.Singleton

class RealGetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
): GetNewsUseCase {
}