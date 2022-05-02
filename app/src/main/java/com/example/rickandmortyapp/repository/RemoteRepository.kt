package com.example.rickandmortyapp.repository

import com.example.rickandmortyapp.models.CharacterModel
import com.example.rickandmortyapp.models.ListCharacterModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface RemoteRepository {
    fun request(page: Int): Observable<List<ListCharacterModel>>
}