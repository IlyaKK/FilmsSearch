package com.elijahcorp.filmssearch.ui.screens.screen_with_two_groups_films.view_model

import com.elijahcorp.filmssearch.domain.entity.Film

sealed class AppState {
    data class Success(val filmsData: List<Film>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}