package com.example.rickandmortyapp.feature.characterscreen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickandmortyapp.data.DataPagingSource
import com.example.rickandmortyapp.domain.RemoteRepository
import javax.inject.Inject

class CharacterViewModel @Inject constructor(
    private val repository: RemoteRepository
) : ViewModel() {

    val characterPages = Pager(
        config = PagingConfig(pageSize = 8),
        pagingSourceFactory = { DataPagingSource(repository) }
    ).flow.cachedIn(viewModelScope)

}