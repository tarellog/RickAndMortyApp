package com.example.rickandmortyapp.feature.characterscreen.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.domain.usecase.CharacterUseCase

class DataPagingSource(
    private val characterUseCase: CharacterUseCase
) : PagingSource<Int, ListCharacter>() {

    override fun getRefreshKey(state: PagingState<Int, ListCharacter>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListCharacter> {
        return try {
            val currentPage = params.key ?: 1
            val response = characterUseCase.getCharacter(currentPage)
            LoadResult.Page(
                response,
                prevKey = null,
                nextKey = if (response.isNotEmpty()) currentPage + 1 else null
            )
        } catch (e: Throwable) {
            LoadResult.Error(e)
        }
    }

}