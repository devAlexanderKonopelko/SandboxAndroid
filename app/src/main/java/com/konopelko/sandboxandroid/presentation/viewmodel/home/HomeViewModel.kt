package com.konopelko.sandboxandroid.presentation.viewmodel.home

import androidx.lifecycle.ViewModel
import com.konopelko.sandboxandroid.domain.usecase.getnews.GetNewsUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getNews: GetNewsUseCase
): ViewModel() {

    
}