package com.elijahcorp.filmssearch.ui.screens.screen_with_two_groups_films.view_model

import com.elijahcorp.filmssearch.domain.entity.Film

sealed class AppState {
    data class SuccessLoadingNowFilms(val filmsNowData: List<Film>) : AppState()
    data class SuccessLoadingUpcomingFilms(val filmsUpcomingData: List<Film>) : AppState()
    data class ErrorNowFilmsLoading(val error: Throwable) : AppState()
    data class ErrorUpcomingFilmsLoading(val error: Throwable) : AppState()

    object LoadingNowFilms : AppState()
    object LoadingUpcomingFilms : AppState()
}