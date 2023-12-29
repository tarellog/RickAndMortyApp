package com.example.rickandmortyapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rickandmortyapp.core.viewmodel.ViewModelFactory
import com.example.rickandmortyapp.feature.mainscreen.MainScreen
import com.example.rickandmortyapp.feature.mainscreen.StateScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModelFactory: () -> ViewModelFactory,
) {
    NavHost(navController = navController, startDestination = Screens.MainScreen.route) {

        composable(route = Screens.MainScreen.route) {
            StateScreen(viewModelFactory = viewModelFactory, navController = navController)
        }

        characterRoute(navController, viewModelFactory)

    }
}