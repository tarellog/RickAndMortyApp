package com.example.rickandmortyapp.feature.characterscreen.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.rickandmortyapp.R

@Composable
fun CharacterItem(
    image: String,
    name: String,
    species: String,
    gender: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(20.dp))
            .fillMaxSize()
            .background(colorResource(R.color.gray))
            .clickable {  }
    ) {
        Image(
            painter = rememberAsyncImagePainter(image),
            contentDescription = null,
            modifier = modifier
                .padding(20.dp)
                .size(80.dp)
                .clip(RoundedCornerShape(20.dp))
        )
        Text(
            text = name,
            textAlign = TextAlign.Center,
            maxLines = 1,
            modifier = modifier.padding(bottom = 20.dp)
        )
        Text(
            text = species,
            textAlign = TextAlign.Center,
            maxLines = 1,
            modifier = modifier.padding(bottom = 20.dp)
        )
        Text(
            text = gender,
            textAlign = TextAlign.Center,
            maxLines = 1,
            modifier = modifier.padding(bottom = 20.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0x58646D)
@Composable
fun CharacterItemPreview() {
    CharacterItem(
        image = "preview",
        name = "title",
        species = "subtitle",
        gender = "description"
    )
}