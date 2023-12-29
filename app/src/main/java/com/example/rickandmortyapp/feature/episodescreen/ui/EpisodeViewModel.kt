package com.example.rickandmortyapp.feature.episodescreen.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.models.ListEpisodeModel
import com.example.rickandmortyapp.domain.usecase.EpisodeByCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodeViewModel @Inject constructor(
    private val episodeByCharacterUseCase: EpisodeByCharacterUseCase,
) : ViewModel() {

    private var _episodeList = MutableStateFlow<List<ListEpisodeModel>>(emptyList())
    val episodeList get() = _episodeList

    fun initCharacterContent(episode: List<Int>) {
        viewModelScope.launch {
            try {
                val episodeList = episodeByCharacterUseCase.getEpisodesByCharacter(episode)
                _episodeList.tryEmit(episodeList)
            } catch (e: Throwable) {
                Log.e("MyTag", "Error", e)
            }
        }
    }

}