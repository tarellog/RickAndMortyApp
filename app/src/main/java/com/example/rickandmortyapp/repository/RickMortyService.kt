package com.example.rickandmortyapp.repository

import com.example.rickandmortyapp.models.CharacterModel
import retrofit2.Call
import retrofit2.http.GET

interface RickMortyService {
    @GET("character")
    fun getApi(): Call<CharacterModel>
}