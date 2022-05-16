package com.example.rickandmortyapp.ui

import android.app.Application
import com.example.rickandmortyapp.di.components.AppComponent
import com.example.rickandmortyapp.di.components.AppComponent.Builder.Companion.build

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = build(this)
    }

}