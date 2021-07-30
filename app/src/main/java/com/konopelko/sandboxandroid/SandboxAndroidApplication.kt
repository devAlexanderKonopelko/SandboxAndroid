package com.konopelko.sandboxandroid

import android.app.Application
import com.konopelko.sandboxandroid.di.component.DaggerApplicationComponent

class SandboxAndroidApplication: Application() {

    val appComponent = DaggerApplicationComponent.create()
}