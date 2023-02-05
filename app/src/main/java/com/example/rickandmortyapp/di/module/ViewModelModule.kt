package com.example.rickandmortyapp.di.module

import com.example.rickandmortyapp.domain.RemoteRepository
import com.example.rickandmortyapp.ui.CharacterViewModel
import com.example.rickandmortyapp.ui.DescriptionCharacterViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideCharacterViewModel(
        repository: RemoteRepository
    ) = CharacterViewModel(repository)

    @Provides
    fun provideDescriptionCharacterViewModel(
        repository: RemoteRepository
    ) = DescriptionCharacterViewModel(repository)

}