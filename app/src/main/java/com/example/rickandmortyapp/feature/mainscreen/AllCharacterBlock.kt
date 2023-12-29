package com.example.rickandmortyapp.feature.mainscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rickandmortyapp.core.SampleData
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.feature.characterscreen.ui.characterlist.CharacterItem

@Composable
fun AllCharacterBlock(
    listCharacter: List<ListCharacter>,
    navController: NavController,
) {
    Column {
        Title(navController = navController)
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(listCharacter) {
                CharacterItem(characterModel = it, navController = navController, sizeItem = 110)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AllCharacterBlockPreview() {
    val context = LocalContext.current
    AllCharacterBlock(
        listCharacter = listOf(SampleData.listData[2]),
        navController = NavController(context)
    )
}