package com.example.rickandmortyapp.feature.characterscreen.ui.characterlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.rickandmortyapp.core.SampleData.listData
import com.example.rickandmortyapp.core.const.LIST_CHARACTER
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.navigation.Screens

@Composable
fun CharacterItem(
    characterModel: ListCharacter,
    navController: NavController,
    sizeItem: Int = 130
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .width(sizeItem.dp)
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set(LIST_CHARACTER, characterModel)
                navController.navigate(Screens.Episode.route)
            }
    ) {
        Image(
            painter = rememberAsyncImagePainter(characterModel.image),
            contentDescription = null,
            modifier = Modifier
                .size(sizeItem.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(20.dp))
        )
        Text(
            text = characterModel.name,
            textAlign = TextAlign.Center,
            maxLines = 1,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterItemPreview() {
    val context = LocalContext.current
    CharacterItem(
        characterModel = listData[2],
        navController = NavController(context)
    )
}