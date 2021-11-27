package com.elijahcorp.filmssearch.ui.screens.screen_with_two_groups_films

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elijahcorp.filmssearch.ui.screens.screen_with_two_groups_films.view_model.AppState
import com.elijahcorp.filmssearch.R
import com.elijahcorp.filmssearch.databinding.ListsFilmsFragmentBinding
import com.elijahcorp.filmssearch.domain.entity.Film
import com.elijahcorp.filmssearch.ui.screens.screen_with_two_groups_films.view_model.ListsFilmsViewModel
import com.google.android.material.snackbar.Snackbar

class ListsFilmsFragment : Fragment(R.layout.lists_films_fragment) {
    private val filmNowAdapter = FilmNowAdapter()
    private val filmUpcomingAdapter = FilmUpcomingNowAdapter()
    private lateinit var binding: ListsFilmsFragmentBinding
    private lateinit var viewModel: ListsFilmsViewModel

    companion object {
        fun newInstance() = ListsFilmsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ListsFilmsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialiseNowPlayingFilmsListRecycleView()
        initialiseUpcomingFilmsListRecycleView()
        viewModel = ViewModelProvider(this).get(ListsFilmsViewModel::class.java)
        viewModel.liveDataNewFilmsToObserve.observe(viewLifecycleOwner, { renderData(it) })
        viewModel.liveDataUpcomingFilmsToObserve.observe(viewLifecycleOwner, { renderData(it) })
        viewModel.getNowFilmsFromServer()
        viewModel.getUpcomingFilmsFromServer()
    }

    private fun initialiseNowPlayingFilmsListRecycleView() {
        binding.filmsNowRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, true)
        binding.filmsNowRecyclerView.adapter = filmNowAdapter
    }

    private fun initialiseUpcomingFilmsListRecycleView() {
        binding.filmsUpcomingRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, true)
        binding.filmsUpcomingRecyclerView.adapter = filmUpcomingAdapter
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.SuccessLoadingNowFilms -> {
                val filmsNowData = appState.filmsNowData
                binding.loadingNowFilmsConstraintLayout.visibility = View.GONE
                setNowFilmsData(filmsNowData)
            }
            is AppState.SuccessLoadingUpcomingFilms -> {
                val filmsUpcomingData = appState.filmsUpcomingData
                binding.loadingUpcomingFilmsConstraintLayout.visibility = View.GONE
                setUpcomingFilmsData(filmsUpcomingData)
            }
            is AppState.LoadingNowFilms -> {
                binding.loadingNowFilmsConstraintLayout.visibility = View.VISIBLE
            }
            is AppState.LoadingUpcomingFilms -> {
                binding.loadingUpcomingFilmsConstraintLayout.visibility = View.VISIBLE
            }
            is AppState.ErrorNowFilmsLoading -> {
                binding.loadingNowFilmsConstraintLayout.visibility = View.GONE
                Snackbar
                    .make(binding.nowFilmConstraintLayout, "Error", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Reload") { viewModel.getNowFilmsFromServer() }
                    .show()
            }
            is AppState.ErrorUpcomingFilmsLoading -> {
                binding.loadingUpcomingFilmsConstraintLayout.visibility = View.GONE
                Snackbar
                    .make(binding.upcomingFilmConstraintLayout, "Error", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Reload") { viewModel.getUpcomingFilmsFromServer() }
                    .show()

            }
        }
    }

    private fun setUpcomingFilmsData(filmsUpcomingData: List<Film>) {
        filmUpcomingAdapter.setData(filmsUpcomingData)
    }

    private fun setNowFilmsData(filmsNowData: List<Film>) {
        filmNowAdapter.setData(filmsNowData)
    }
}