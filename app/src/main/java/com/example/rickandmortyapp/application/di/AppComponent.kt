package com.example.rickandmortyapp.application.di

import com.example.rickandmortyapp.di.modules.ViewModelModule
import com.example.rickandmortyapp.di.modules.NetworkModule
import com.example.rickandmortyapp.di.modules.UseCaseModule
import com.example.rickandmortyapp.feature.characterscreen.ui.CharacterFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        ViewModelModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {

    fun inject(fragment: CharacterFragment)

}