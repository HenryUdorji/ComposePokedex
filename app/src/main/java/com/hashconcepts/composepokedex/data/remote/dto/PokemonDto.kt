package com.hashconcepts.composepokedex.data.remote.dto

data class PokemonDto(
    val avg_spawns: Double,
    val candy: String,
    val candy_count: Int,
    val egg: String,
    val height: String,
    val id: Int,
    val img: String,
    val multipliers: List<Double>,
    val name: String,
    val next_evolution: List<NextEvolution>,
    val num: String,
    val prev_evolution: List<PrevEvolution>,
    val spawn_chance: Double,
    val spawn_time: String,
    val type: List<String>,
    val weaknesses: List<String>,
    val weight: String
)