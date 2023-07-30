package com.example.rickandmortyapp.core

import androidx.paging.PagingData
import com.example.rickandmortyapp.data.models.LocationCharacterModel
import com.example.rickandmortyapp.domain.models.ListCharacter
import kotlinx.coroutines.flow.MutableStateFlow

object SampleData {
    val listData = listOf(
        ListCharacter(
            20,
            30,
            "Lexi",
            "Test...Test...Test...",
            "dss",
            "dsdsd",
            LocationCharacterModel("dssdsds", "dsdsdsd"),
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            listOf("dfdfd"),
        ),
        ListCharacter(
            20,
            40,
            "Lexi",
            "Test...Test...Test...",
            "dss",
            "dsdsd",
            LocationCharacterModel("dssdsds", "dsdsdsd"),
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            listOf("dfdfd"),
        ),
        ListCharacter(
            20,
            50,
            "Lexi",
            "Test...Test...Test...",
            "dss",
            "dsdsd",
            LocationCharacterModel("dssdsds", "dsdsdsd"),
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            listOf("dfdfd"),
        ),
        ListCharacter(
            20,
            60,
            "Lexi",
            "Test...Test...Test...",
            "dss",
            "dsdsd",
            LocationCharacterModel("dssdsds", "dsdsdsd"),
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            listOf("dfdfd"),
        ),
    )
    private val fakeData = PagingData.from(listData)
    val flowFakeData = MutableStateFlow(fakeData)
}