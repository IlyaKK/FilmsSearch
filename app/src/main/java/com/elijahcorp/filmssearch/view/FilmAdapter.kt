package com.elijahcorp.filmssearch.view

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elijahcorp.filmssearch.model.Film

class FilmAdapter : RecyclerView.Adapter<FilmVh>() {
    private var dataFilms: List<Film> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(dataFilms: List<Film>) {
        this.dataFilms = dataFilms
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmVh {
        return FilmVh(parent)
    }

    override fun onBindViewHolder(holder: FilmVh, position: Int) {
        holder.bind(getOneFilm(position))
    }

    private fun getOneFilm(position: Int): Film {
        return dataFilms[position]
    }

    override fun getItemCount(): Int {
        return dataFilms.size
    }
}