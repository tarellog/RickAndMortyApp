package com.example.rickandmortyapp.feature.characterscreen.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rickandmortyapp.domain.models.ListCharacter

@Composable
fun CharacterScreen(
    list: List<ListCharacter>,
    onCharacterClicked: (ListCharacter) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier.fillMaxSize()
    ) {
        CharacterList(
            listItem = list,
            onCharacterClicked = onCharacterClicked,
            modifier = modifier.padding(it),
            onTitleClicked = {}
        )
    }
}