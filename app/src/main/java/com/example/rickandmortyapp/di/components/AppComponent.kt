package com.example.rickandmortyapp.di.components

import android.content.Context
import com.example.rickandmortyapp.di.modules.AppModule
import com.example.rickandmortyapp.domain.RemoteRepository
import com.example.rickandmortyapp.ui.FactoryViewModels
import com.example.rickandmortyapp.ui.GeneralFragment
import com.example.rickandmortyapp.ui.GeneralViewModel
import com.example.rickandmortyapp.ui.SecondViewModel
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

}