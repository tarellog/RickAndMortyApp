package com.example.rickandmortyapp.feature.mainscreen

import androidx.compose.runtime.Immutable
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.domain.models.ListEpisodes

sealed interface StateMainScreen {

    object LoaderState : StateMainScreen
    object ErrorState : StateMainScreen

    @Immutable
    data class Success(
        val listCharacter: List<ListCharacter>,
        val listEpisodes: List<ListEpisodes>,
    ) : StateMainScreen

}