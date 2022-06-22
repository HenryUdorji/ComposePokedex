package com.hashconcepts.composepokedex.presentation.screens.pokedex_list

import com.hashconcepts.composepokedex.domain.model.Pokemon

/**
 * @created 20/06/2022 - 12:55 PM
 * @project ComposePokedex
 * @author  ifechukwu.udorji
 */
data class PokedexListScreenState(
    val isLoading: Boolean = false,
    val error: String = "",
    val pokedex: List<Pokemon> = emptyList()
)
