package com.elijahcorp.filmssearch.view_model

import com.elijahcorp.filmssearch.model.Film

sealed class AppState {
    data class Success(val filmsData: List<Film>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}