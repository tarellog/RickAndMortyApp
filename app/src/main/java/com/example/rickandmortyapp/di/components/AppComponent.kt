package com.example.rickandmortyapp.di.components

import com.example.rickandmortyapp.di.modules.AppModule
import com.example.rickandmortyapp.domain.RemoteRepository
import com.example.rickandmortyapp.ui.App
import com.example.rickandmortyapp.ui.GeneralFragment
import dagger.Component

@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    fun providesRemoteRepository(): RemoteRepository

    fun inject(fragment: GeneralFragment)

    class Builder {
        companion object {
            fun build(app: App) : AppComponent {
                return DaggerAppComponent.builder().build()
            }
        }
    }
}