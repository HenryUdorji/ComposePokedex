package com.hashconcepts.composepokedex.di

import com.hashconcepts.composepokedex.data.repository.PokedexRepositoryImpl
import com.hashconcepts.composepokedex.domain.repository.PokedexRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

/**
 * @created 20/06/2022 - 3:07 AM
 * @project ComposePokedex
 * @author  ifechukwu.udorji
 */

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindsPokedexRepository(pokedexRepositoryImpl: PokedexRepositoryImpl): PokedexRepository
}