package com.example.rickandmortyapp.domain.usecase

import com.example.rickandmortyapp.domain.models.ListCharacter

interface CharacterUseCase {
    suspend fun getCharacter(page: Int): List<ListCharacter>
}