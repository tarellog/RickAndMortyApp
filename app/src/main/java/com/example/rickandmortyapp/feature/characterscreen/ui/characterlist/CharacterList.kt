package com.example.rickandmortyapp.feature.characterscreen.ui.characterlist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.core.ui.compose.MainTitle
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.core.SampleData.flowFakeData
import com.example.rickandmortyapp.core.SampleData.listData
import kotlinx.coroutines.flow.Flow

@Composable
fun CharacterList(
    listItem: Flow<PagingData<ListCharacter>>,
    onCharacterClicked: (ListCharacter) -> Unit,
    modifier: Modifier = Modifier,
    onTitleClicked: () -> Unit
) {
    val lazyPagingItems = listItem.collectAsLazyPagingItems()
    MainTitle(
        title = stringResource(id = R.string.character_title),
        onTitleClicked = { onTitleClicked() }
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(vertical = 5.dp, horizontal = 15.dp),
            modifier = modifier
        ) {
            items(lazyPagingItems.itemCount) { item ->
                lazyPagingItems[item]?.let {
                    CharacterItem(
                        characterModel = it,
                        onCharacterClicked = onCharacterClicked
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterListPreview() {
    CharacterList(listItem = flowFakeData, onCharacterClicked = { listData}, onTitleClicked = {})
}