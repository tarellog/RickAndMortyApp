package com.example.rickandmortyapp.feature.episodescreen.ui.episodelist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rickandmortyapp.data.models.EpisodeModel
import com.example.rickandmortyapp.domain.models.ListCharacter

@Composable
fun EpisodeList(
    episodeList: List<EpisodeModel>,
    characterInfo: List<ListCharacter>,
    padding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(padding),
    ) {
        items(characterInfo) {item ->
            EpisodeHeader(listCharacter = item)
        }
        items(episodeList) {item ->
            EpisodeItem(episodeModel = item)
        }
    }
}