package com.example.rickandmortyapp.feature.characterscreen.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.PagingData
import com.example.rickandmortyapp.domain.models.ListCharacter
import kotlinx.coroutines.flow.Flow

@Composable
fun CharacterScreen(
    list: Flow<PagingData<ListCharacter>>,
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