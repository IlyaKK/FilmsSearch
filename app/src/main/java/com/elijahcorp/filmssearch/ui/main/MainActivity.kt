package com.elijahcorp.filmssearch.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elijahcorp.filmssearch.R
import com.elijahcorp.filmssearch.ui.screens.screen_with_two_groups_films.ListsFilmsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_frame_layout, ListsFilmsFragment.newInstance())
                .commitNow()
        }
    }
}