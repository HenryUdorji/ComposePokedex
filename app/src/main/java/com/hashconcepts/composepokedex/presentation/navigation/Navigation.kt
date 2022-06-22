package com.hashconcepts.composepokedex.presentation.navigation

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.hashconcepts.composepokedex.domain.model.Pokemon
import com.hashconcepts.composepokedex.presentation.screens.pokedex_detail.DetailScreen
import com.hashconcepts.composepokedex.presentation.screens.pokedex_list.PokedexListScreen
import com.hashconcepts.composepokedex.utils.Constants

/**
 * @created 20/06/2022 - 9:25 AM
 * @project ComposePokedex
 * @author  ifechukwu.udorji
 */

@Composable
fun Navigation() {

    val navController = rememberNavController()
    val systemUiController = rememberSystemUiController()

    NavHost(navController = navController, startDestination = Screens.PokedexListScreen.route) {
        composable(Screens.PokedexListScreen.route) {
            PokedexListScreen(systemUiController) { pokemon ->
                navController.currentBackStackEntry?.savedStateHandle?.set(Constants.POKEMON, pokemon)
                navController.navigate(Screens.DetailScreen.route)
            }
        }

        composable(
            route = Screens.DetailScreen.route,
        ) {
            val pokemon by remember {
                mutableStateOf(navController.previousBackStackEntry?.savedStateHandle?.get<Pokemon>(Constants.POKEMON)!!)
            }
            DetailScreen(
                pokemon,
                systemUiController,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}