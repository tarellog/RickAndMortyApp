package com.example.rickandmortyapp.data

import com.example.rickandmortyapp.data.models.CharacterModel
import com.example.rickandmortyapp.data.models.EpisodeModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickMortyService {

    @GET("character")
    suspend fun getCharacter(@Query("page") page: Int = 1): CharacterModel

    @GET("episode/{episodes}")
    suspend fun getEpisodes(@Path("episodes") episodes: List<Int>): List<EpisodeModel>
}