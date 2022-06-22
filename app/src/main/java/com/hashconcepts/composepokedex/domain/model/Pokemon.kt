package com.hashconcepts.composepokedex.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val id: Int,
    val img: String,
    val name: String,
    val type: List<String>,
    val weaknesses: List<String>,
    val height: String,
    val weight: String,
    val randomColor: Int
): Parcelable {
    fun getIdString(): String = String.format("#%03d", id)
}