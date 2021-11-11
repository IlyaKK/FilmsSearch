package com.elijahcorp.filmssearch.model

class RepositoryImpl : Repository {
    override fun getFilmsFromServer(): List<Film> {
        val films: ArrayList<Film> = ArrayList()
        films.add(
            Film(
                name = "Дюна",
                data = "03.09.2021",
                rang = 7.8,
                pathOfImage = "app/src/main/res/drawable/dune.jpeg"
            )
        )
        return films
    }

    override fun getFilmsFromLocalStorage(): List<Film> {
        TODO("Not yet implemented")
    }


}