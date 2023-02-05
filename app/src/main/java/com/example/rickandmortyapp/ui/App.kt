package com.example.rickandmortyapp.ui

import android.app.Application
import com.example.rickandmortyapp.di.components.AppComponent
import com.example.rickandmortyapp.di.components.DaggerAppComponent
import com.example.rickandmortyapp.di.module.AppModule
import com.example.rickandmortyapp.ui.CharacterFragment.Companion.instance

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        instance = this
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule())
            .build()
    }

}