package com.example.rickandmortyapp.feature.characterscreen.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.PagingData
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.feature.characterscreen.ui.characterlist.CharacterList
import kotlinx.coroutines.flow.Flow

@Composable
fun CharacterScreen(
    list: Flow<PagingData<ListCharacter>>,
    onCharacterClicked: (ListCharacter) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier.fillMaxSize()
    ) {
        CharacterList(
            listItem = list,
            onCharacterClicked = onCharacterClicked,
            onTitleClicked = {},
        )
    }
}