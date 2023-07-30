package com.example.rickandmortyapp.domain.usecase

import com.example.rickandmortyapp.data.models.EpisodeModel

interface DataEpisodeUseCase {
    suspend fun getEpisodes(episode: List<Int>): List<EpisodeModel>
}