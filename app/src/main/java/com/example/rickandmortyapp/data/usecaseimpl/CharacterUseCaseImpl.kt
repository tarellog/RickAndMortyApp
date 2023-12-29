package com.example.rickandmortyapp.data.usecaseimpl

import com.example.rickandmortyapp.data.repository.RemoteRepository
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.domain.usecase.CharacterUseCase

class CharacterUseCaseImpl(
    private val remoteRepository: RemoteRepository
) : CharacterUseCase {

    override suspend fun getCharacter(page: Int): List<ListCharacter> =
        remoteRepository.getCharacter(page)

}