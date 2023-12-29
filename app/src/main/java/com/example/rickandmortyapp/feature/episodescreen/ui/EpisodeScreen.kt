package com.example.rickandmortyapp.feature.episodescreen.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.rickandmortyapp.feature.episodescreen.ui.episodelist.EpisodeList
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rickandmortyapp.core.viewmodel.ViewModelFactory
import com.example.rickandmortyapp.domain.models.ListCharacter

@Composable
fun EpisodeScreen(
    characterData: ListCharacter,
    viewModelFactory: () -> ViewModelFactory,
) {
    val viewModel: EpisodeViewModel = viewModel(factory = viewModelFactory())
    val episodeList by viewModel.episodeList.collectAsState()
    viewModel.initCharacterContent(characterData.getEpisodeList())

    Scaffold {
        EpisodeList(
            episodeList = episodeList,
            characterData = characterData,
            padding = it
        )
    }
}