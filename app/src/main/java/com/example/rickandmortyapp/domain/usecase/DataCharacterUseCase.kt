package com.example.rickandmortyapp.domain.usecase

import com.example.rickandmortyapp.domain.models.ListCharacter

interface DataCharacterUseCase {
    suspend fun getCharacter(page: Int): List<ListCharacter>
}