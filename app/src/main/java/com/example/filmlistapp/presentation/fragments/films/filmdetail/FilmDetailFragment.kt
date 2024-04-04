package com.example.filmlistapp.presentation.fragments.films.filmdetail

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.filmlistapp.R

class FilmDetailFragment : Fragment() {

    companion object {
        fun newInstance() = FilmDetailFragment()
    }

    private val viewModel: FilmDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_film_detail, container, false)
    }
}