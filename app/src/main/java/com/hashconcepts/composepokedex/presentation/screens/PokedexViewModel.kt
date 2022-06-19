package com.hashconcepts.composepokedex.presentation.screens

import androidx.lifecycle.ViewModel
import com.hashconcepts.composepokedex.data.remote.PokedexApi
import com.hashconcepts.composepokedex.utils.ConnectionLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @created 19/06/2022 - 3:38 PM
 * @project ComposePokedex
 * @author  ifechukwu.udorji
 */

@HiltViewModel
class PokedexViewModel @Inject constructor(
    pokedexApi: PokedexApi,
    connectionLiveData: ConnectionLiveData
): ViewModel() {

    val connection = connectionLiveData


}