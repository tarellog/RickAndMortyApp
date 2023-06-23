package com.example.rickandmortyapp.data

import com.example.rickandmortyapp.data.models.CharacterModel
import com.example.rickandmortyapp.data.models.EpisodeModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickMortyService {

    @GET("character")
    suspend fun getApi(@Query("page") page: Int = 1): CharacterModel

    @GET("episode/{episodes}")
    fun getEpisodes(@Path("episodes") episodes: List<Int>): Single<List<EpisodeModel>>
}