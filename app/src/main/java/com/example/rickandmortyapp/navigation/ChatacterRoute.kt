package com.example.rickandmortyapp.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.rickandmortyapp.core.const.LIST_CHARACTER
import com.example.rickandmortyapp.core.ui.viewmodel.ViewModelFactory
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.feature.characterscreen.ui.CharacterScreen
import com.example.rickandmortyapp.feature.episodescreen.ui.EpisodeScreen

fun NavGraphBuilder.characterRoute(
    navController: NavController,
    viewModelFactory: () -> ViewModelFactory
) {
    navigation(startDestination = Screens.Character.route, route = Screens.CharacterRoute.route) {
        composable(route = Screens.Character.route) {
            CharacterScreen(
                viewModelFactory = { viewModelFactory() },
                navController = navController,
            )
        }
        composable(route = Screens.Episode.route,) {
            navController.previousBackStackEntry?.savedStateHandle?.get<ListCharacter>(
                LIST_CHARACTER
            )
                ?.let { listCharacter ->
                    EpisodeScreen(
                        viewModelFactory = { viewModelFactory() },
                        characterData = listCharacter
                    )
                }
        }
    }
}