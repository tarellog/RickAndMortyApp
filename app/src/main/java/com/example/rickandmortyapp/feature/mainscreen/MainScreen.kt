package com.example.rickandmortyapp.feature.mainscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.rickandmortyapp.core.ui.ErrorScreen
import com.example.rickandmortyapp.core.ui.LoadingScreen
import com.example.rickandmortyapp.core.viewmodel.ViewModelFactory
import com.example.rickandmortyapp.domain.models.ListCharacter

@Composable
fun StateScreen(
    viewModelFactory: () -> ViewModelFactory,
    viewModel: MainViewModel = viewModel(factory = viewModelFactory()),
    navController: NavController,
) {
    val stateScreen = viewModel.stateScreen.collectAsState().value
    Surface(modifier = Modifier.fillMaxSize()) {
        when (stateScreen) {
            is StateMainScreen.Success -> {
                MainScreen(listCharacter = stateScreen.listCharacter, navController = navController)
            }
            is StateMainScreen.LoaderState -> LoadingScreen()
            is StateMainScreen.ErrorState -> ErrorScreen(retryAction = { viewModel.getCharacter() })
        }
    }
}

@Composable
fun MainScreen(
    listCharacter: List<ListCharacter>,
    navController: NavController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        LazyColumn() {
            items(1) {
                ImageBlock()
                AllCharacterBlock(listCharacter, navController)
            }
        }
    }
}