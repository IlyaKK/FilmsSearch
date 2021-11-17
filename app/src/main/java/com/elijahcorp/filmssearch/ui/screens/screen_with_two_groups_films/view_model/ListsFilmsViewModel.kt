package com.elijahcorp.filmssearch.ui.screens.screen_with_two_groups_films.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elijahcorp.filmssearch.domain.repo.Repository
import com.elijahcorp.filmssearch.domain.repo.impl.RepositoryImpl
import java.lang.Thread.sleep

class ListsFilmsViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImpl: Repository = RepositoryImpl()
) :
    ViewModel() {

    fun getLiveData() = liveDataToObserve

    fun getFilmsFromLocalSource() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(3000)
            liveDataToObserve.postValue(AppState.Success(repositoryImpl.getFilmsFromServer()))
        }.start()
    }
}