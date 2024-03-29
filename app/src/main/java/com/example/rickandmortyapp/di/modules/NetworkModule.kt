package com.example.rickandmortyapp.di.modules

import com.example.rickandmortyapp.data.repository.RemoteRepositoryImpl
import com.example.rickandmortyapp.data.RickMortyService
import com.example.rickandmortyapp.data.repository.RemoteRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    @Provides
    fun providesRickMortyService(retrofit: Retrofit): RickMortyService =
        retrofit.create(RickMortyService::class.java)

    @Provides
    fun providesRemoteRepository(service: RickMortyService): RemoteRepository =
    RemoteRepositoryImpl(service)

}