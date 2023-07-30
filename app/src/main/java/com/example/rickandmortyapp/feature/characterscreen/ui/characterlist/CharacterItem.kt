package com.example.rickandmortyapp.feature.characterscreen.ui.characterlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.rickandmortyapp.core.const.LIST_CHARACTER
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.navigation.Screens

@Composable
fun CharacterItem(
    characterModel: ListCharacter,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set(LIST_CHARACTER, characterModel)
                navController.navigate(Screens.Episode.route)
            }
    ) {
        Image(
            painter = rememberAsyncImagePainter(characterModel.image),
            contentDescription = null,
            modifier = modifier
                .size(160.dp)
                .clip(RoundedCornerShape(20.dp))
        )
        Text(
            text = characterModel.name,
            textAlign = TextAlign.Center,
            maxLines = 1,
            modifier = modifier.padding(top = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterItemPreview() {
//    CharacterItem(
//        characterModel = listData[2],
//        navController = { NavController() }
//    )
}