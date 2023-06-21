package com.example.rickandmortyapp.feature.characterscreen.ui

import com.example.rickandmortyapp.data.models.ListCharacterModel
import com.example.rickandmortyapp.data.models.LocationCharacterModel
import com.example.rickandmortyapp.data.models.OriginModel

object SampleData {
    val listData = listOf(
        ListCharacterModel(
            id = 0,
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            "Lexi",
            "Test...Test...Test...",
            "dss",
            "dsdsd",
            OriginModel("dsd","dsdsds"),
            LocationCharacterModel("dssdsds", "dsdsdsd"),
            "okey",
            listOf("dfdfd"),
            "dfdfdfd",
            "dsfdsfs"
        ),
        ListCharacterModel(
            id = 1,
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            "Lexi",
            "Test...Test...Test...",
            "dss",
            "dsdsd",
            OriginModel("dsd","dsdsds"),
            LocationCharacterModel("dssdsds", "dsdsdsd"),
            "okey",
            listOf("dfdfd"),
            "dfdfdfd",
            "dsfdsfs"
        ),
        ListCharacterModel(
            id = 2,
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            "Lexi",
            "Test...Test...Test...",
            "dss",
            "dsdsd",
            OriginModel("dsd","dsdsds"),
            LocationCharacterModel("dssdsds", "dsdsdsd"),
            "okey",
            listOf("dfdfd"),
            "dfdfdfd",
            "dsfdsfs"
        ),
    )
}