package com.elijahcorp.filmssearch.ui.screens.screen_with_two_groups_films

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.elijahcorp.filmssearch.R
import com.elijahcorp.filmssearch.domain.entity.Film
import com.google.android.material.textview.MaterialTextView

class FilmUpcomingVh(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private lateinit var posterUpcomingImageView: ImageView
    private lateinit var nameFilmUpcomingTextView: MaterialTextView
    private lateinit var dataFilmUpcomingTextView: MaterialTextView

    constructor(parent: ViewGroup) : this(
        LayoutInflater.from(parent.context).inflate(R.layout.one_film_upcoming, parent, false)
    ) {
        initialiseViews()
    }

    private fun initialiseViews() {
        posterUpcomingImageView = itemView.findViewById(R.id.poster_upcoming_image_view)
        nameFilmUpcomingTextView = itemView.findViewById(R.id.name_film_upcoming_text_view)
        dataFilmUpcomingTextView = itemView.findViewById(R.id.data_film_upcoming_text_view)
    }

    fun bind(oneUpcomingFilm: Film) {
        posterUpcomingImageView.setImageResource(oneUpcomingFilm.pathOfImage)
        nameFilmUpcomingTextView.text = oneUpcomingFilm.name
        dataFilmUpcomingTextView.text = oneUpcomingFilm.data
    }
}