package com.hashconcepts.composepokedex.data.remote

import com.hashconcepts.composepokedex.data.remote.dto.PokedexResponse
import retrofit2.http.GET

/**
 * @created 19/06/2022 - 1:26 PM
 * @project ComposePokedex
 * @author  ifechukwu.udorji
 */
interface PokedexApi {

    @GET("pokedex.json")
    suspend fun fetchPokedex(): PokedexResponse
}