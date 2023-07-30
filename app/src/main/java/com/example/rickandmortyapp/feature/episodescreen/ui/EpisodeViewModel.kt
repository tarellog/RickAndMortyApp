package com.example.rickandmortyapp.feature.episodescreen.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.models.EpisodeModel
import com.example.rickandmortyapp.domain.usecase.DataEpisodeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodeViewModel @Inject constructor(
    private val dataEpisodeUseCase: DataEpisodeUseCase,
) : ViewModel() {

    private var _episodeList = MutableStateFlow<List<EpisodeModel>>(emptyList())
    val episodeList get() = _episodeList

    fun initCharacterContent(episode: List<Int>) {
        viewModelScope.launch {
            try {
                val episodeList = dataEpisodeUseCase.getEpisodes(episode)
                _episodeList.tryEmit(episodeList)
            } catch (e: Throwable) {
                Log.e("MyTag", "Error", e)
            }
        }
    }

}