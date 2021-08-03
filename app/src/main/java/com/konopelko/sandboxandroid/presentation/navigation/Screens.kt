package com.konopelko.sandboxandroid.presentation.navigation

import androidx.fragment.app.Fragment
import com.konopelko.sandboxandroid.data.api.entity.response.NewsResponse
import com.konopelko.sandboxandroid.presentation.view.details.DetailsFragment
import com.konopelko.sandboxandroid.presentation.view.home.HomeFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object HomeScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = HomeFragment()
    }

    class DetailsScreen(private val article: NewsResponse.Article) : SupportAppScreen() {
        override fun getFragment(): Fragment = DetailsFragment.newInstance(article)
    }
}