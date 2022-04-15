package com.example.rickandmortyapp.models

import com.google.gson.annotations.SerializedName

data class LocationCharacterModel(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
