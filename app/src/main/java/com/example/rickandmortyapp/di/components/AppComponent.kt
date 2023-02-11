package com.example.rickandmortyapp.di.components

import com.example.rickandmortyapp.di.module.ViewModelModule
import com.example.rickandmortyapp.di.modules.AppModule
import com.example.rickandmortyapp.domain.RemoteRepository
import com.example.rickandmortyapp.ui.*
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun providesRemoteRepository(): RemoteRepository

    fun viewModelFactory(): FactoryViewModels

    fun inject(fragment: GeneralFragment)

    fun inject(secondFragment: SecondFragment)

}