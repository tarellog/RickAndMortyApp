package com.example.rickandmortyapp.repository

import android.util.Log
import com.example.rickandmortyapp.models.CharacterModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RemoteRepositoryImpl(private val model: (CharacterModel) -> Unit) : RemoteRepository {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiRickMortyService: RickMortyService =
        retrofit.create(RickMortyService::class.java)

    private val responseCallback = object : Callback<CharacterModel> {

        override fun onResponse(call: Call<CharacterModel>, response: Response<CharacterModel>) {
            response.body()?.let { model(it) }
        }

        override fun onFailure(call: Call<CharacterModel>, t: Throwable) {
            Log.e("error", t.toString())
        }
    }

    override fun request() {
        apiRickMortyService.getApi().enqueue(responseCallback)
    }
}