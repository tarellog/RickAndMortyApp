package com.example.rickandmortyapp.domain.models

import androidx.compose.runtime.Immutable

@Immutable
data class ListEpisodes(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val characters: List<String>,
    val url: String,
    val created: String
)
