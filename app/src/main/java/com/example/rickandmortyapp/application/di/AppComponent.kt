package com.example.rickandmortyapp.application.di

import com.example.rickandmortyapp.di.modules.ViewModelModule
import com.example.rickandmortyapp.di.modules.AppModule
import com.example.rickandmortyapp.feature.characterscreen.ui.CharacterFragment
import com.example.rickandmortyapp.feature.episodescreen.ui.EpisodeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(fragment: CharacterFragment)

    fun secondInject(secondFragment: EpisodeFragment)

}