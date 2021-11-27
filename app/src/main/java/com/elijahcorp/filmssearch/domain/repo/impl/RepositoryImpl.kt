package com.elijahcorp.filmssearch.domain.repo.impl

import com.elijahcorp.filmssearch.R
import com.elijahcorp.filmssearch.domain.entity.Film
import com.elijahcorp.filmssearch.domain.repo.Repository

class RepositoryImpl : Repository {
    override fun getNowFilmsFromServer(): List<Film> {
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

    override fun getUpcomingFilmsFromServer(): List<Film> {
        val films: ArrayList<Film> = ArrayList()
        films.add(
            Film(
                name = "Дюна",
                data = "03.09.2021",
                pathOfImage = R.drawable.dune
            )
        )
        return films
    }
}