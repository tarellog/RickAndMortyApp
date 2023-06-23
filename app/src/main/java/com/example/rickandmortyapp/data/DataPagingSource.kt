package com.example.rickandmortyapp.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyapp.domain.RemoteRepository
import com.example.rickandmortyapp.domain.models.ListCharacter

class DataPagingSource(
    private val remoteRepository: RemoteRepository
) : PagingSource<Int, ListCharacter>() {

    override fun getRefreshKey(state: PagingState<Int, ListCharacter>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListCharacter> {
        return try {
            val currentPage = params.key ?: 1
            val response = remoteRepository.request(currentPage)
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