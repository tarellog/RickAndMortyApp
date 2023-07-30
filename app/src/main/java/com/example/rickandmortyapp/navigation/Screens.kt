package com.example.rickandmortyapp.navigation

sealed class Screens(val route: String) {

    object Character : Screens("character_screen")
    object Episode : Screens("episode_screen")

}
