package com.example.rickandmortyapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rickandmortyapp.core.const.LIST_CHARACTER
import com.example.rickandmortyapp.core.ui.viewmodel.ViewModelFactory
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.feature.characterscreen.ui.CharacterScreen
import com.example.rickandmortyapp.feature.episodescreen.ui.EpisodeScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModelFactory: () -> ViewModelFactory,
) {
    NavHost(navController = navController, startDestination = Screens.Character.route) {
        composable(route = Screens.Character.route) {
            CharacterScreen(
                viewModelFactory = { viewModelFactory() },
                navController = navController,
            )
        }
        composable(route = Screens.Episode.route,) {
            navController.previousBackStackEntry?.savedStateHandle?.get<ListCharacter>(LIST_CHARACTER)
                ?.let { listCharacter ->
                    EpisodeScreen(
                        viewModelFactory = { viewModelFactory() },
                        characterData = listCharacter
                    )
                }
        }
    }
}