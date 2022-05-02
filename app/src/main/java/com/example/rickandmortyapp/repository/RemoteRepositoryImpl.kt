package com.example.rickandmortyapp.repository

import com.example.rickandmortyapp.models.ListCharacterModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RemoteRepositoryImpl : RemoteRepository {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    private val apiRickMortyService: RickMortyService =
        retrofit.create(RickMortyService::class.java)

    override fun request(page: Int): Observable<List<ListCharacterModel>> {
        return apiRickMortyService.getApi(page)
            .subscribeOn(Schedulers.io())
            .map { it.results }
            .observeOn(AndroidSchedulers.mainThread())
    }
}