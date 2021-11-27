package com.elijahcorp.filmssearch.ui.screens.screen_with_two_groups_films

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elijahcorp.filmssearch.domain.entity.Film

class FilmNowAdapter : RecyclerView.Adapter<FilmNowVh>() {
    private var dataFilms: List<Film> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(dataFilms: List<Film>) {
        this.dataFilms = dataFilms
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmNowVh {
        return FilmNowVh(parent)
    }

    override fun onBindViewHolder(holder: FilmNowVh, position: Int) {
        holder.bind(getOneFilm(position))
    }

    private fun getOneFilm(position: Int): Film {
        return dataFilms[position]
    }

    override fun getItemCount(): Int {
        return dataFilms.size
    }
}