package com.hashconcepts.composepokedex.presentation.navigation

import com.hashconcepts.composepokedex.utils.Constants

/**
 * @created 20/06/2022 - 9:18 AM
 * @project ComposePokedex
 * @author  ifechukwu.udorji
 */
sealed class Screens(val route: String) {
    object PokedexListScreen: Screens(Constants.HOME_ROUTE)
    object DetailScreen: Screens(Constants.DETAIL_ROUTE)

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
