package com.elijahcorp.filmssearch.ui.screens.screen_with_two_groups_films

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elijahcorp.filmssearch.domain.entity.Film

class FilmUpcomingNowAdapter : RecyclerView.Adapter<FilmUpcomingVh>() {
    private var dataUpcomingFilms: List<Film> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(filmsUpcomingData: List<Film>) {
        this.dataUpcomingFilms = filmsUpcomingData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmUpcomingVh {
        return FilmUpcomingVh(parent)
    }

    override fun onBindViewHolder(holder: FilmUpcomingVh, position: Int) {
        holder.bind(getOneUpcomingFilm(position))
    }

    private fun getOneUpcomingFilm(position: Int): Film {
        return dataUpcomingFilms[position]
    }

    override fun getItemCount(): Int {
        return dataUpcomingFilms.size
    }
}