package com.konopelko.sandboxandroid.presentation.view.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.konopelko.sandboxandroid.R
import com.konopelko.sandboxandroid.SandboxAndroidApplication
import com.konopelko.sandboxandroid.presentation.viewmodel.home.HomeViewModel
import javax.inject.Inject

class HomeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        (applicationContext as SandboxAndroidApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}