package com.example.rickandmortyapp.domain.usecase

import com.example.rickandmortyapp.data.models.ListEpisodeModel

interface EpisodeByCharacterUseCase {
    suspend fun getEpisodesByCharacter(episode: List<Int>): List<ListEpisodeModel>
}