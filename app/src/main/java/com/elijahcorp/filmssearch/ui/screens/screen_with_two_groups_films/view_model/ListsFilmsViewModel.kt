package com.elijahcorp.filmssearch.ui.screens.screen_with_two_groups_films.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elijahcorp.filmssearch.domain.repo.Repository
import com.elijahcorp.filmssearch.domain.repo.impl.RepositoryImpl
import java.lang.Thread.sleep

class ListsFilmsViewModel(
    private val repositoryImpl: Repository = RepositoryImpl()
) :
    ViewModel() {
    val liveDataNewFilmsToObserve = MutableLiveData<AppState>()
    val liveDataUpcomingFilmsToObserve = MutableLiveData<AppState>()

    fun getNowFilmsFromServer() {
        liveDataNewFilmsToObserve.postValue(AppState.LoadingNowFilms)
        Thread {
            sleep(2000)
            liveDataNewFilmsToObserve.postValue(AppState.SuccessLoadingNowFilms(repositoryImpl.getNowFilmsFromServer()))
        }.start()
    }

    fun getUpcomingFilmsFromServer() {
        liveDataUpcomingFilmsToObserve.postValue(AppState.LoadingUpcomingFilms)
        Thread {
            sleep(2000)
            liveDataUpcomingFilmsToObserve.postValue(AppState.SuccessLoadingUpcomingFilms(repositoryImpl.getUpcomingFilmsFromServer()))
        }.start()
    }
}