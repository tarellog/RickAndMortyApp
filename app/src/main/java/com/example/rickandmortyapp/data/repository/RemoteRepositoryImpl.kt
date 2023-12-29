package com.example.rickandmortyapp.data.repository

import android.util.Log
import com.example.rickandmortyapp.core.extansion.mapToListCharacter
import com.example.rickandmortyapp.core.extansion.mapToListEpisodes
import com.example.rickandmortyapp.data.RickMortyService
import com.example.rickandmortyapp.data.models.ListEpisodeModel
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.domain.models.ListEpisodes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteRepositoryImpl (
    private val apiRickMortyService: RickMortyService
) : RemoteRepository {

    override suspend fun getCharacter(page: Int): List<ListCharacter> {
        return withContext(Dispatchers.IO) {
            apiRickMortyService.getCharacter(page).mapToListCharacter()
        }
    }

    override suspend fun getEpisodesByCharacter(episodes: List<Int>): List<ListEpisodeModel> {
        return withContext(Dispatchers.IO) {
            apiRickMortyService.getEpisodesByCharacter(episodes)
        }
    }

    override suspend fun getAllEpisodes(): List<ListEpisodes> =
        try {
            apiRickMortyService.getAllEpisodes().mapToListEpisodes()
        } catch (e: Exception) {
            Log.d("error", "error", e)
            throw IllegalArgumentException("fatal")
        }

}