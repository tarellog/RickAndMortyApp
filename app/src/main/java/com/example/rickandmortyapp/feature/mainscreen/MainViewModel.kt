package com.example.rickandmortyapp.feature.mainscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.domain.usecase.CharacterUseCase
import com.example.rickandmortyapp.domain.usecase.EpisodeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val characterUseCase: CharacterUseCase,
    private val episodeUseCase: EpisodeUseCase,
) : ViewModel() {

    private val _stateScreen = MutableStateFlow<StateMainScreen>(StateMainScreen.LoaderState)
    val stateScreen: StateFlow<StateMainScreen> = _stateScreen.asStateFlow()

    init {
        getCharacter()
//        getEpisodes()
    }

    fun getCharacter() {
        viewModelScope.launch {
            _stateScreen.tryEmit(StateMainScreen.LoaderState)
            try {
                _stateScreen.tryEmit(
                    StateMainScreen.Success(
                        listCharacter = characterUseCase.getCharacter(1).take(8),
                        listEpisodes = episodeUseCase.getAllEpisodes().take(8)
                    )
                )
            } catch (e: Exception) {
                Log.e("error", "error", e)
                _stateScreen.tryEmit(StateMainScreen.ErrorState)
            }
        }
    }
//
//    private fun getEpisodes() {
//        viewModelScope.launch {
//            try {
//                val listEpisodes = episodeUseCase.getAllEpisodes().take(8)
//                listEpisodes
//            } catch (e: Exception) {
//                Log.e("error", "error", e)
//            }
//        }
//    }

}