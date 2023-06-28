package com.example.rickandmortyapp.feature.characterscreen.ui

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.rickandmortyapp.data.DataPagingSource
import com.example.rickandmortyapp.domain.usecase.DataCharacterUseCase
import javax.inject.Inject

class CharacterViewModel @Inject constructor(
    private val dataCharacterUseCase: DataCharacterUseCase
) : ViewModel() {

    val characterPages = Pager(
        PagingConfig(pageSize = 42),
    ) {
        DataPagingSource(dataCharacterUseCase)
    }.flow

}