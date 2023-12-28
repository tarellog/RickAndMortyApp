package com.example.rickandmortyapp.feature.mainscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.rickandmortyapp.core.ui.viewmodel.ViewModelFactory
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.feature.characterscreen.ui.characterlist.CharacterItem

@Composable
fun MainScreen(
    viewModelFactory: () -> ViewModelFactory,
    viewModel: MainViewModel = viewModel(factory = viewModelFactory()),
    navController: NavController,
) {
    val listCharacter = viewModel.character.collectAsState()
    val rememberListCharacter = remember { listCharacter }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        LazyColumn() {
            items(1) {
                MainCharacterScreen(rememberListCharacter.value, navController)
            }
        }
    }
}

@Composable
fun MainCharacterScreen(
    listCharacter: List<ListCharacter>,
    navController: NavController,
) {
    Spacer(modifier = Modifier.height(30.dp))
    Row() {
        Text(text = "Все персонажи")
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = null
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(listCharacter) {
            CharacterItem(characterModel = it, navController = navController)
        }
    }
}