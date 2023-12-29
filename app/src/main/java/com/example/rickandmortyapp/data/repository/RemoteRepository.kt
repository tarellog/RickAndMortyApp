package com.example.rickandmortyapp.data.repository

import com.example.rickandmortyapp.data.models.ListEpisodeModel
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.domain.models.ListEpisodes

interface RemoteRepository {
    suspend fun getCharacter(page: Int): List<ListCharacter>
    suspend fun getEpisodesByCharacter(episodes: List<Int>): List<ListEpisodeModel>
    suspend fun getAllEpisodes(): List<ListEpisodes>
}