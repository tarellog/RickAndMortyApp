package com.example.rickandmortyapp.feature.episodescreen.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortyapp.feature.episodescreen.ui.episodelist.EpisodeList
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun EpisodeScreen(
    viewModelFactory: () -> ViewModelProvider.Factory,
    viewModel: EpisodeViewModel = viewModel(factory = viewModelFactory())
) {
    val characterInfo by viewModel.characterInfo.collectAsState()
    val episodeList by viewModel.episodeList.collectAsState()

    Scaffold {
        EpisodeList(
            episodeList = episodeList,
            characterInfo = characterInfo,
            padding = it
        )
    }

}