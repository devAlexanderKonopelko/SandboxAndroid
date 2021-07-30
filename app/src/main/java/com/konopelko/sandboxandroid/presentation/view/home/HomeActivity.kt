package com.konopelko.sandboxandroid.presentation.view.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.konopelko.sandboxandroid.SandboxAndroidApplication

class HomeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as SandboxAndroidApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }
}