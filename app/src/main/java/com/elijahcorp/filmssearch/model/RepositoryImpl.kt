package com.elijahcorp.filmssearch.model

import com.elijahcorp.filmssearch.R

class RepositoryImpl : Repository {
    override fun getFilmsFromServer(): List<Film> {
        val films: ArrayList<Film> = ArrayList()
        films.add(
            Film(
                name = "Дюна",
                data = "03.09.2021",
                rang = 7.8,
                pathOfImage = R.drawable.dune
            )
        )
        return films
    }
}