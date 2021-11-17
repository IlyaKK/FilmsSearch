package com.elijahcorp.filmssearch.model

interface Repository {
    fun getFilmsFromServer(): List<Film>
}