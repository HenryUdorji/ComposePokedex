package com.hashconcepts.composepokedex.data.repository

import com.hashconcepts.composepokedex.data.remote.PokedexApi
import com.hashconcepts.composepokedex.data.remote.dto.PokedexResponse
import com.hashconcepts.composepokedex.domain.repository.PokedexRepository
import com.hashconcepts.composepokedex.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

/**
 * @created 20/06/2022 - 2:17 AM
 * @project ComposePokedex
 * @author  ifechukwu.udorji
 */
class PokedexRepositoryImpl @Inject constructor(
    private val pokedexApi: PokedexApi
) : PokedexRepository {

    override suspend fun fetchPokedex(): Flow<Resource<PokedexResponse>> {
        return flow {
           try {
               emit(Resource.Loading())
               val response = pokedexApi.fetchPokedex()
               emit(Resource.Success(response))
           } catch(e: HttpException) {
               emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
           } catch(e: IOException) {
               emit(Resource.Error("Couldn't reach server. Check your internet connection."))
           }
        }
    }
}