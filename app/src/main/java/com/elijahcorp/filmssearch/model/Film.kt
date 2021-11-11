package com.elijahcorp.filmssearch.model

data class Film(
    val name: String,
    val data: String,
    val rang: Double,
    val pathOfImage: Int,
    val favorite: Boolean = false
)