package com.example.rickandmortyapp.di.components

import android.content.Context
import com.example.rickandmortyapp.di.modules.AppModule
import com.example.rickandmortyapp.domain.RemoteRepository
import com.example.rickandmortyapp.ui.*
import dagger.Component

@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    fun providesRemoteRepository(): RemoteRepository

    fun myViewModel(): GeneralViewModel

    fun mySecondViewModel(): SecondViewModel

    fun viewModelFactory(): FactoryViewModels

    fun inject(fragment: GeneralFragment)

    fun inject(secondFragment: SecondFragment)

}