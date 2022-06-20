package com.hashconcepts.composepokedex.domain.model

data class Pokemon(
    val id: Int,
    val img: String,
    val name: String,
    val type: List<String>,
    val weaknesses: List<String>,
    val height: String,
    val weight: String
) {
    fun getIdString(): String = String.format("#%03d", id)
}