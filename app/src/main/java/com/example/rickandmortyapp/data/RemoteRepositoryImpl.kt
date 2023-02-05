package com.example.rickandmortyapp.data

import com.example.rickandmortyapp.domain.RemoteRepository
import com.example.rickandmortyapp.data.models.EpisodeModel
import com.example.rickandmortyapp.data.models.ListCharacterModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RemoteRepositoryImpl (
    private val apiRickMortyService: RickMortyService
) : RemoteRepository {

    override fun getCharacter(page: Int): Observable<List<ListCharacterModel>> {
        return apiRickMortyService.getCharacter(page)
            .subscribeOn(Schedulers.io())
            .map { it.results }
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getEpisodes(episodes: List<Int>): Single<List<EpisodeModel>> {
        return apiRickMortyService.getEpisodes(episodes)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}