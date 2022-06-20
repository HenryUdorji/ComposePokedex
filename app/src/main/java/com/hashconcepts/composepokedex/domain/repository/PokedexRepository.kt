package com.hashconcepts.composepokedex.domain.repository

import com.hashconcepts.composepokedex.data.remote.dto.PokedexResponse
import com.hashconcepts.composepokedex.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * @created 20/06/2022 - 2:17 AM
 * @project ComposePokedex
 * @author  ifechukwu.udorji
 */
interface PokedexRepository {

    suspend fun fetchPokedex(): Flow<Resource<PokedexResponse>>
}