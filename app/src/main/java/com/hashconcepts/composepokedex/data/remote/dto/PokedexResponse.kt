package com.hashconcepts.composepokedex.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PokedexResponse(
    @SerializedName("pokemon")
    val pokemonDto: List<PokemonDto>
)