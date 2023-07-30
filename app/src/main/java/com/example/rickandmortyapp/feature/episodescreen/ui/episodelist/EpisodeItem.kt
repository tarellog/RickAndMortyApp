package com.example.rickandmortyapp.feature.episodescreen.ui.episodelist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.models.EpisodeModel

@Composable
fun EpisodeItem(
    modifier: Modifier = Modifier,
    episodeModel: EpisodeModel
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = stringResource(id = R.string.episod, episodeModel.id),
            maxLines = 1,
            style = MaterialTheme.typography.displayLarge,
            fontSize = 20.sp
        )
        Text(
            text = stringResource(id = R.string.series, episodeModel.name),
            maxLines = 1,
            style = MaterialTheme.typography.displayLarge,
            fontSize = 20.sp
        )
        Text(
            modifier = modifier.padding(bottom = 10.dp),
            text = stringResource(id = R.string.data, episodeModel.air_date),
            style = MaterialTheme.typography.displayLarge,
            maxLines = 1,
            fontSize = 20.sp
        )
    }
}