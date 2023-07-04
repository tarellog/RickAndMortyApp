package com.example.rickandmortyapp.feature.episodescreen.ui

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.models.EpisodeModel
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.domain.usecase.DataEpisodeUseCase
import com.example.rickandmortyapp.feature.characterscreen.ui.CharacterFragment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodeViewModel @Inject constructor(
    private val dataEpisodeUseCase: DataEpisodeUseCase,
) : ViewModel() {

    private var _characterInfo = MutableStateFlow<List<ListCharacter>>(emptyList())
    val characterInfo get() = _characterInfo

    private var _episodeList = MutableStateFlow<List<EpisodeModel>>(emptyList())
    val episodeList get() = _episodeList

    fun initByBundle(arguments: Bundle) {
        viewModelScope.launch {
            try {
                val dataForScreen = arguments.getParcelable<ListCharacter>(CharacterFragment.DATA_KEY)
                dataForScreen?.let { data ->
                    val episodeList = dataEpisodeUseCase.getEpisodes(data.getEpisodeList())
                    val characterInfo = listOf(data)
                    _characterInfo.tryEmit(characterInfo)
                    _episodeList.tryEmit(episodeList)
                }
            } catch (e: Throwable) {
                Log.e("MyTag", "Error", e)
            }
        }
    }

}