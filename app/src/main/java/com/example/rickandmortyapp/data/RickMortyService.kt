package com.example.rickandmortyapp.data

import com.example.rickandmortyapp.data.models.CharacterModel
import com.example.rickandmortyapp.data.models.EpisodeModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickMortyService {
    @GET("character")
    fun getCharacter(@Query("page") page: Int = 1): Observable<CharacterModel>

    @GET("episode/{episodes}")
    fun getEpisodes(@Path("episodes") episodes: List<Int>): Single<List<EpisodeModel>>
}