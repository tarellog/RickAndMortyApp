package com.example.rickandmortyapp.core.extansion

import com.example.rickandmortyapp.data.models.EpisodeModel
import com.example.rickandmortyapp.domain.models.ListEpisodes

fun EpisodeModel.mapToListEpisodes(): List<ListEpisodes> =
    this.results.map {
        ListEpisodes(
            id = it.id,
            name = it.name,
            airDate = it.air_date,
            episode = it.episode,
            characters = it.characters,
            url = it.url,
            created = it.created
        )
    }
