package com.konopelko.sandboxandroid

import android.app.Application
import com.konopelko.sandboxandroid.di.component.ApplicationComponent
import com.konopelko.sandboxandroid.di.component.DaggerApplicationComponent

class SandboxAndroidApplication: Application() {

    val appComponent: ApplicationComponent = DaggerApplicationComponent.create()
}