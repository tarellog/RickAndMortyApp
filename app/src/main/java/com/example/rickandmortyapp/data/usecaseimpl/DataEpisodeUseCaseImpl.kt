package com.example.rickandmortyapp.data.usecaseimpl

import com.example.rickandmortyapp.data.repository.RemoteRepository
import com.example.rickandmortyapp.data.models.EpisodeModel
import com.example.rickandmortyapp.domain.usecase.DataEpisodeUseCase

class DataEpisodeUseCaseImpl(
    private val remoteRepository: RemoteRepository
) : DataEpisodeUseCase {

    override suspend fun getEpisodes(episode: List<Int>): List<EpisodeModel> =
        remoteRepository.getEpisodes(episode)

}