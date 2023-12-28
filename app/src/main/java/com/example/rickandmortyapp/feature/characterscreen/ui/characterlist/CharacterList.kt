package com.example.rickandmortyapp.feature.characterscreen.ui.characterlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.rickandmortyapp.core.SampleData.flowFakeData
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.core.ui.compose.ErrorScreen
import com.example.rickandmortyapp.core.ui.compose.LoadingScreen
import kotlinx.coroutines.flow.Flow

@Composable
fun CharacterList(
    listCharacter: Flow<PagingData<ListCharacter>>,
    navController: NavController,
) {
    val lazyPagingItems = listCharacter.collectAsLazyPagingItems()
    val gridState = rememberLazyGridState()

    when (lazyPagingItems.loadState.refresh) {
        is LoadState.NotLoading -> Unit
        is LoadState.Loading -> LoadingScreen()
        is LoadState.Error -> ErrorScreen(retryAction = { lazyPagingItems.refresh() })
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        state = gridState
    ) {
        items(lazyPagingItems.itemCount) { item ->
            lazyPagingItems[item]?.let {
                CharacterItem(
                    characterModel = it,
                    navController = navController
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterListPreview() {
    CharacterList(
        listCharacter = flowFakeData,
        navController = NavController(LocalContext.current)
    )
}