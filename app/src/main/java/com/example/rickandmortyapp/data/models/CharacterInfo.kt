package com.example.rickandmortyapp.data.models

import com.example.rickandmortyapp.domain.BaseModel

data class CharacterInfo(
    val name: String,
    val image: String,
    val species: String,
    val gender: String,
    val status: String,
    val location: String,
) : BaseModel
