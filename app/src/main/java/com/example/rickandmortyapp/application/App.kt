package com.example.rickandmortyapp.application

import android.app.Application
import com.example.rickandmortyapp.application.di.AppComponent
import com.example.rickandmortyapp.application.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .create()
    }

}