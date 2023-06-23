package com.example.rickandmortyapp.core.extansion

import com.example.rickandmortyapp.data.models.CharacterModel
import com.example.rickandmortyapp.domain.models.ListCharacter

fun CharacterModel.mapToListCharacter(): List<ListCharacter> =
    this.results.map { listCharacter ->
        ListCharacter(
            page = this.info.pages,
            name = listCharacter.name,
            status = listCharacter.status,
            species = listCharacter.species,
            gender = listCharacter.gender,
            location = listCharacter.location,
            image = listCharacter.image,
            episode = listCharacter.episode
        )
    }