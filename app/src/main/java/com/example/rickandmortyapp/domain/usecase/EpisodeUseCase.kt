package com.example.rickandmortyapp.domain.usecase

import com.example.rickandmortyapp.domain.models.ListEpisodes

interface EpisodeUseCase {
    suspend fun getAllEpisodes(): List<ListEpisodes>
}