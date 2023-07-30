package com.example.rickandmortyapp.feature.characterscreen.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.rickandmortyapp.core.ui.viewmodel.ViewModelFactory
import com.example.rickandmortyapp.feature.characterscreen.ui.characterlist.CharacterList

@Composable
fun CharacterScreen(
    viewModelFactory: () -> ViewModelFactory,
    viewModel: CharacterViewModel = viewModel(factory = viewModelFactory()),
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val listCharacter = viewModel.characterPages
        CharacterList(
            listCharacter = listCharacter,
            navController = navController,
        )
    }
}