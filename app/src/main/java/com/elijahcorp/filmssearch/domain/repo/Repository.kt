package com.elijahcorp.filmssearch.domain.repo

import com.elijahcorp.filmssearch.domain.entity.Film

interface Repository {
    fun getFilmsFromServer(): List<Film>
}