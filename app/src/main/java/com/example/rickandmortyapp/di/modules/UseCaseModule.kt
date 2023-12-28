package com.example.rickandmortyapp.di.modules

import com.example.rickandmortyapp.data.repository.RemoteRepository
import com.example.rickandmortyapp.data.usecaseimpl.DataCharacterUseCaseImpl
import com.example.rickandmortyapp.data.usecaseimpl.DataEpisodeUseCaseImpl
import com.example.rickandmortyapp.domain.usecase.DataCharacterUseCase
import com.example.rickandmortyapp.domain.usecase.DataEpisodeUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun providesDataCharacterUseCase(remoteRepository: RemoteRepository): DataCharacterUseCase =
        DataCharacterUseCaseImpl(remoteRepository)

    @Singleton
    @Provides
    fun providesDataEpisodeUseCase(remoteRepository: RemoteRepository): DataEpisodeUseCase =
        DataEpisodeUseCaseImpl(remoteRepository)

}