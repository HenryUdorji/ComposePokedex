package com.hashconcepts.composepokedex.presentation.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hashconcepts.composepokedex.data.remote.PokedexApi
import com.hashconcepts.composepokedex.data.remote.dto.toPokemon
import com.hashconcepts.composepokedex.domain.repository.PokedexRepository
import com.hashconcepts.composepokedex.presentation.screens.pokedex_list.PokedexListScreenState
import com.hashconcepts.composepokedex.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @created 19/06/2022 - 3:38 PM
 * @project ComposePokedex
 * @author  ifechukwu.udorji
 */

@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val pokedexRepository: PokedexRepository
): ViewModel() {

    private val _pokedexScreenState = mutableStateOf(PokedexListScreenState())
    val pokedexScreenState: State<PokedexListScreenState> = _pokedexScreenState

    init {
        viewModelScope.launch {
            fetchPokedex()
        }
    }

    private suspend fun fetchPokedex() {
        pokedexRepository.fetchPokedex().onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    _pokedexScreenState.value = PokedexListScreenState(isLoading = true)
                }
                is Resource.Error -> {
                    _pokedexScreenState.value = PokedexListScreenState(error = result.message!!)
                }
                is Resource.Success -> {
                    _pokedexScreenState.value = PokedexListScreenState(pokedex = result.data!!.pokemonDto.map { it.toPokemon() })
                }
            }
        }.launchIn(viewModelScope)
    }
}