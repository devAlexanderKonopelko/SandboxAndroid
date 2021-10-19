package com.konopelko.sandboxandroid.presentation.view.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.konopelko.sandboxandroid.R
import com.konopelko.sandboxandroid.presentation.navigation.Screens
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Replace

class HomeActivity: AppCompatActivity() {

    private val navHolder: NavigatorHolder by inject()

    private val navigator = SupportAppNavigator(this, R.id.homeContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupHomeScreen()
    }

    private fun setupHomeScreen() {
        val screen = Screens.HomeScreen
        navigator.applyCommands(arrayOf(Replace(screen)))
    }

    override fun onResume() {
        super.onResume()
        navHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navHolder.removeNavigator()
        super.onPause()
    }
}