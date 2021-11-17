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
    private val filmAdapter = FilmAdapter()
    private lateinit var binding: ListsFilmsFragmentBinding

    companion object {
        fun newInstance() = ListsFilmsFragment()
    }

    private lateinit var viewModel: ListsFilmsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ListsFilmsFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialiseNowPlayingListRecycleView()
        viewModel = ViewModelProvider(this).get(ListsFilmsViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, { renderData(it) })
        viewModel.getFilmsFromLocalSource()
    }

    private fun initialiseNowPlayingListRecycleView() {
        binding.filmsNowRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, true)
        binding.filmsNowRecyclerView.adapter = filmAdapter
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                val filmsData = appState.filmsData
                binding.loadingConstraintLayout.visibility = View.GONE
                setData(filmsData)
            }
            is AppState.Loading -> {
                binding.loadingConstraintLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                binding.loadingConstraintLayout.visibility = View.GONE
                Snackbar
                    .make(binding.mainConstraintLayout, "Error", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Reload") { viewModel.getFilmsFromLocalSource() }
                    .show()
            }
        }
    }

    private fun setData(filmsData: List<Film>) {
        filmAdapter.setData(filmsData)
    }
}