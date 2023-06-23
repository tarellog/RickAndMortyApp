package com.example.rickandmortyapp.domain

import com.example.rickandmortyapp.data.models.EpisodeModel
import com.example.rickandmortyapp.domain.models.ListCharacter
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface RemoteRepository {
    fun request(page: Int): Observable<List<ListCharacter>>
    fun getEpisodes(episodes: List<Int>): Single<List<EpisodeModel>>
}