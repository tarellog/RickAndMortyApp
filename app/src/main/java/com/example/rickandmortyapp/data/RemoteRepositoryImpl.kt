package com.example.rickandmortyapp.data

import com.example.rickandmortyapp.core.extansion.mapToListCharacter
import com.example.rickandmortyapp.data.models.EpisodeModel
import com.example.rickandmortyapp.domain.models.ListCharacter
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

    override suspend fun getEpisodes(episodes: List<Int>): List<EpisodeModel> {
        return withContext(Dispatchers.IO) {
            apiRickMortyService.getEpisodes(episodes)
        }
    }

}