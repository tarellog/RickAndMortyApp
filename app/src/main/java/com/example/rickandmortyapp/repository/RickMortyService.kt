package com.example.rickandmortyapp.repository

import com.example.rickandmortyapp.models.CharacterModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RickMortyService {
    @GET("character")
    fun getApi(@Query("page") page: Int = 1): Call<CharacterModel>
}