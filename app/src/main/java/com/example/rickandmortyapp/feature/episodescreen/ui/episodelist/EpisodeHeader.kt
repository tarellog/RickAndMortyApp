package com.example.rickandmortyapp.feature.episodescreen.ui.episodelist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.core.SampleData.listData
import com.example.rickandmortyapp.domain.models.ListCharacter

@Composable
fun EpisodeHeader(
    modifier: Modifier = Modifier,
    listCharacter: ListCharacter
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
            .background(colorResource(R.color.main_color)),
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = listCharacter.image),
            contentDescription = null,
            modifier = modifier
                .size(220.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Column(
            modifier = modifier
                .padding(vertical = 20.dp)
        ) {
            Text(
                text = stringResource(id = R.string.name, listCharacter.name),
                maxLines = 1,
                style = MaterialTheme.typography.displayLarge,
                fontSize = 20.sp
            )
            Text(
                text = stringResource(id = R.string.species, listCharacter.species),
                maxLines = 1,
                modifier = modifier.padding(top = 5.dp),
                style = MaterialTheme.typography.displayLarge,
                fontSize = 20.sp
            )
            Text(
                text = stringResource(id = R.string.gender, listCharacter.gender),
                maxLines = 1,
                modifier = modifier.padding(top = 5.dp),
                style = MaterialTheme.typography.displayLarge,
                fontSize = 20.sp
            )
            Text(
                text = stringResource(id = R.string.status, listCharacter.status),
                maxLines = 1,
                modifier = modifier.padding(top = 5.dp),
                style = MaterialTheme.typography.displayLarge,
                fontSize = 20.sp
            )
            Text(
                text = stringResource(id = R.string.location, listCharacter.location.name),
                maxLines = 1,
                modifier = modifier.padding(top = 5.dp),
                style = MaterialTheme.typography.displayLarge,
                fontSize = 20.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EpisodeHeaderPreview() {
    EpisodeHeader(
        listCharacter = listData[2]
    )
}