package com.example.rickandmortyapp.di.modules

import com.example.rickandmortyapp.data.repository.RemoteRepository
import com.example.rickandmortyapp.data.usecaseimpl.CharacterUseCaseImpl
import com.example.rickandmortyapp.data.usecaseimpl.EpisodeByCharacterUseCaseImpl
import com.example.rickandmortyapp.data.usecaseimpl.EpisodeUseCaseImpl
import com.example.rickandmortyapp.domain.usecase.CharacterUseCase
import com.example.rickandmortyapp.domain.usecase.EpisodeByCharacterUseCase
import com.example.rickandmortyapp.domain.usecase.EpisodeUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun providesCharacterUseCase(remoteRepository: RemoteRepository): CharacterUseCase =
        CharacterUseCaseImpl(remoteRepository)

    @Singleton
    @Provides
    fun providesEpisodeByCharacterUseCase(remoteRepository: RemoteRepository): EpisodeByCharacterUseCase =
        EpisodeByCharacterUseCaseImpl(remoteRepository)

    @Provides
    fun providesEpisodeUseCase(remoteRepository: RemoteRepository): EpisodeUseCase =
        EpisodeUseCaseImpl(remoteRepository)

}