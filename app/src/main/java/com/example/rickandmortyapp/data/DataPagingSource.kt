package com.example.rickandmortyapp.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyapp.data.models.ListCharacterModel
import com.example.rickandmortyapp.domain.RemoteRepository

class DataPagingSource(
    private val remoteRepository: RemoteRepository
) : PagingSource<Int, ListCharacterModel>() {

    override fun getRefreshKey(state: PagingState<Int, ListCharacterModel>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListCharacterModel> {
        return try {
            val currentPage = params.key ?: 1
            val response = remoteRepository.request(currentPage).blockingFirst()
            LoadResult.Page(
                response,
                prevKey = null,
                nextKey = null
            )
        } catch (e: Throwable) {
            LoadResult.Error(e)
        }
    }

}