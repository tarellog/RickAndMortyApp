package com.example.rickandmortyapp.feature.characterscreen.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.feature.characterscreen.ui.characterlist.CharacterList

@Composable
fun CharacterScreen(
    viewModelFactory: () -> ViewModelProvider.Factory,
    viewModel: CharacterViewModel = viewModel(factory = viewModelFactory()),
    onCharacterClicked: (ListCharacter) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val listCharacter = viewModel.characterPages
        CharacterList(
            listCharacter = listCharacter,
            onCharacterClicked = onCharacterClicked,
        )
    }
}