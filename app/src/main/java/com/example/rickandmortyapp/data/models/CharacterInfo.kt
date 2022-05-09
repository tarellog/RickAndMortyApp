package com.example.rickandmortyapp.data.models

data class CharacterInfo(
    val name: String,
    val image: String,
    val species: String,
    val gender: String,
    val status: String,
    val location: String,
    val episodes: List<String>
)
