package com.example.rickandmortyapp.data.models

import com.google.gson.annotations.SerializedName

data class InfoCharacterModel(
    @SerializedName("count")
    val count: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("prev")
    val prev: String
)
