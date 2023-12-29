package com.example.rickandmortyapp.feature.episodescreen.ui.episodelist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rickandmortyapp.data.models.ListEpisodeModel
import com.example.rickandmortyapp.domain.models.ListCharacter

@Composable
fun EpisodeList(
    episodeList: List<ListEpisodeModel>,
    characterData: ListCharacter,
    padding: PaddingValues,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(padding),
        state = listState
    ) {
        item {
            EpisodeHeader(listCharacter = characterData)
        }
        items(episodeList) {item ->
            EpisodeItem(listEpisodeModel = item)
        }
    }
}