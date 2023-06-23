package com.example.rickandmortyapp.data.usecaseimpl

import com.example.rickandmortyapp.data.RemoteRepository
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.domain.usecase.DataCharacterUseCase

class DataCharacterUseCaseImpl(
    private val remoteRepository: RemoteRepository
) : DataCharacterUseCase {

    override suspend fun getCharacter(page: Int): List<ListCharacter> {
        return remoteRepository.getCharacter(page)
    }

}