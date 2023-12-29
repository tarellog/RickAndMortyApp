package com.example.rickandmortyapp.data.usecaseimpl

import com.example.rickandmortyapp.data.repository.RemoteRepository
import com.example.rickandmortyapp.data.models.ListEpisodeModel
import com.example.rickandmortyapp.domain.usecase.EpisodeByCharacterUseCase

class EpisodeByCharacterUseCaseImpl(
    private val remoteRepository: RemoteRepository
) : EpisodeByCharacterUseCase {

    override suspend fun getEpisodesByCharacter(episode: List<Int>): List<ListEpisodeModel> =
        remoteRepository.getEpisodesByCharacter(episode)

}