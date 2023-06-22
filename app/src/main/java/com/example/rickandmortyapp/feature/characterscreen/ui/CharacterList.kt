package com.example.rickandmortyapp.feature.characterscreen.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.core.ui.compose.MainTitle
import com.example.rickandmortyapp.data.models.ListCharacterModel
import com.example.rickandmortyapp.feature.characterscreen.ui.SampleData.listData

@Composable
fun CharacterList(
    listItem: List<ListCharacterModel>,
    onCharacterClicked: (ListCharacterModel) -> Unit,
    modifier: Modifier = Modifier,
    onTitleClicked: () -> Unit
) {
    MainTitle(
        title = stringResource(id = R.string.character_title),
        onTitleClicked = { onTitleClicked() }
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(vertical = 5.dp, horizontal = 15.dp),
            modifier = modifier
        ) {
            items(listItem) {item ->
                CharacterItem(
                    characterModel = item,
                    onCharacterClicked = onCharacterClicked
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterListPreview() {
    CharacterList(listItem = listData, onCharacterClicked = { listData}, onTitleClicked = {})
}