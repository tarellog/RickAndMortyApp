package com.example.rickandmortyapp.data.models

import com.google.gson.annotations.SerializedName

data class CharacterModel(
    @SerializedName("info")
    val info: InfoCharacterModel,
    @SerializedName("results")
    val results: List<ListCharacterModel>
)
