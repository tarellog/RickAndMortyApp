package com.example.rickandmortyapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rickandmortyapp.feature.characterscreen.ui.CharacterScreen
import com.example.rickandmortyapp.feature.episodescreen.ui.EpisodeScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModelFactory: () -> ViewModelProvider.Factory,
//    openEpisodeScreen: (ListCharacter) -> Unit,
) {
    NavHost(navController = navController, startDestination = Screens.Character.route) {
        composable(route = Screens.Character.route) {
            CharacterScreen(
                viewModelFactory = { viewModelFactory() },
                navController = navController,
            )
        }
        composable(route = Screens.Episode.route) {
            EpisodeScreen(
                viewModelFactory = { viewModelFactory() },
            )
        }
    }
}