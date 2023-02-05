package com.example.rickandmortyapp.di.components

import com.example.rickandmortyapp.di.module.AppModule
import com.example.rickandmortyapp.di.module.ViewModelModule
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

    fun myViewModel(): CharacterViewModel

    fun mySecondViewModel(): DescriptionCharacterViewModel

    fun viewModelFactory(): FactoryViewModels

    fun inject(fragment: CharacterFragment)

    fun inject(secondFragment: DescriptionCharacterFragment)

}