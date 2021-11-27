package com.elijahcorp.filmssearch.domain.entity

data class Film(
    val name: String,
    val data: String,
    val rang: Double = 0.0,
    val pathOfImage: Int,
    val favorite: Boolean = false
)