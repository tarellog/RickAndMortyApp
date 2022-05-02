package com.example.rickandmortyapp.repository

import com.example.rickandmortyapp.models.ListCharacterModel
import io.reactivex.rxjava3.core.Observable

interface RemoteRepository {
    fun request(page: Int): Observable<List<ListCharacterModel>>
}