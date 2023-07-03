package com.example.rickandmortyapp.feature.characterscreen.ui.characterlist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.core.ui.compose.MainTitle
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.core.ui.compose.ErrorScreen
import com.example.rickandmortyapp.core.ui.compose.LoadingScreen
import com.example.rickandmortyapp.feature.characterscreen.ui.CharacterViewModel

@Composable
fun CharacterList(
    viewModel: CharacterViewModel,
    onCharacterClicked: (ListCharacter) -> Unit,
    onTitleClicked: () -> Unit
) {
    val lazyPagingItems = viewModel.characterPages.collectAsLazyPagingItems()
    MainTitle(
        title = stringResource(id = R.string.character_title),
        onTitleClicked = { onTitleClicked() }
    ) {
        when (lazyPagingItems.loadState.refresh) {
            is LoadState.NotLoading -> Unit
            is LoadState.Loading -> LoadingScreen()
            is LoadState.Error -> ErrorScreen(retryAction = { lazyPagingItems.refresh() })
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(vertical = 5.dp, horizontal = 15.dp),
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
//    CharacterList( onTitleClicked = {})
}