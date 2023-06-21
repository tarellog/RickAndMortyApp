package com.example.rickandmortyapp.feature.characterscreen.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rickandmortyapp.data.models.ListCharacterModel

@Composable
fun CharacterScreen(
    list: List<ListCharacterModel>,
    onCharacterClicked: (ListCharacterModel) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier.fillMaxSize()
    ) {
        CharacterList(
            listItem = list,
            onCharacterClicked = onCharacterClicked,
            modifier = modifier.padding(it)
        )
    }
}