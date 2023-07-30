package com.example.rickandmortyapp.data.repository

import com.example.rickandmortyapp.data.models.EpisodeModel
import com.example.rickandmortyapp.domain.models.ListCharacter

interface RemoteRepository {
    suspend fun getCharacter(page: Int): List<ListCharacter>
    suspend fun getEpisodes(episodes: List<Int>): List<EpisodeModel>
}