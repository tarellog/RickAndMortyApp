package com.example.rickandmortyapp.data

import com.example.rickandmortyapp.core.extansion.mapToListCharacter
import com.example.rickandmortyapp.domain.RemoteRepository
import com.example.rickandmortyapp.data.models.EpisodeModel
import com.example.rickandmortyapp.domain.models.ListCharacter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteRepositoryImpl (
    private val apiRickMortyService: RickMortyService
) : RemoteRepository {

    override suspend fun request(page: Int): List<ListCharacter> {
        return withContext(Dispatchers.IO) {
            apiRickMortyService.getApi(page).mapToListCharacter()
        }
    }

    override fun getEpisodes(episodes: List<Int>): Single<List<EpisodeModel>> {
        return apiRickMortyService.getEpisodes(episodes)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}