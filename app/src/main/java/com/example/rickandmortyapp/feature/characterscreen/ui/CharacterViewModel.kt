package com.example.rickandmortyapp.feature.characterscreen.ui

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.rickandmortyapp.feature.characterscreen.paging.DataPagingSource
import com.example.rickandmortyapp.domain.usecase.CharacterUseCase
import javax.inject.Inject

class CharacterViewModel @Inject constructor(
    private val characterUseCase: CharacterUseCase
) : ViewModel() {

    val characterPages = Pager(
        PagingConfig(pageSize = 1),
    ) {
        DataPagingSource(characterUseCase)
    }.flow

}