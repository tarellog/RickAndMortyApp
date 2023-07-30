package com.example.rickandmortyapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.rickandmortyapp.core.ui.viewmodel.ViewModelFactory

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModelFactory: () -> ViewModelFactory,
) {
    NavHost(navController = navController, startDestination = Screens.CharacterRoute.route) {

        characterRoute(navController, viewModelFactory)

    }
}