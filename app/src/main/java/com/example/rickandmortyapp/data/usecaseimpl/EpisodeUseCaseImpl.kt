package com.example.rickandmortyapp.data.usecaseimpl

import com.example.rickandmortyapp.data.repository.RemoteRepository
import com.example.rickandmortyapp.domain.models.ListEpisodes
import com.example.rickandmortyapp.domain.usecase.EpisodeUseCase
import javax.inject.Inject

class EpisodeUseCaseImpl @Inject constructor(
    private val remoteRepository: RemoteRepository
) : EpisodeUseCase {

    override suspend fun getAllEpisodes(): List<ListEpisodes> = remoteRepository.getAllEpisodes()

}