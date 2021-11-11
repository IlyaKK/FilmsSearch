package com.elijahcorp.filmssearch.model

data class Film(
    val name: String,
    val upcoming: Boolean = false,
    val data: String,
    val rang: Double,
    val pathOfImage: String,
    val favorite: Boolean = false
)