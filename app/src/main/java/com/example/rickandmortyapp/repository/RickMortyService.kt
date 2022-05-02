package com.example.rickandmortyapp.repository

import com.example.rickandmortyapp.models.CharacterModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RickMortyService {
    @GET("character")
    fun getApi(@Query("page") page: Int = 1): Observable<CharacterModel>
}