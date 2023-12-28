package com.example.rickandmortyapp.navigation

import com.example.rickandmortyapp.core.const.CHARACTER_ROUTE
import com.example.rickandmortyapp.core.const.CHARACTER_SCREEN
import com.example.rickandmortyapp.core.const.EPISODE_SCREEN
import com.example.rickandmortyapp.core.const.MAIN_SCREEN

sealed class Screens(val route: String) {

    object MainScreen : Screens(MAIN_SCREEN)
    object Character : Screens(CHARACTER_SCREEN)
    object Episode : Screens(EPISODE_SCREEN)
    object CharacterRoute: Screens(CHARACTER_ROUTE)

}
