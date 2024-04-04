package com.example.filmlistapp.presentation.fragments.testList.listitem

import android.graphics.drawable.Drawable
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.filmlistapp.R
import com.example.filmlistapp.data.repositoryimpl.RepositoryImpl
import com.example.filmlistapp.databinding.FragmentFilmListBinding
import com.example.filmlistapp.databinding.FragmentListItemBinding
import com.example.filmlistapp.presentation.fragments.films.filmlist.FilmListViewModel
import com.example.filmlistapp.presentation.fragments.films.filmlist.FilmListViewModelFactory

class ListItemFragment : Fragment() {
    private lateinit var binding: FragmentListItemBinding
    private lateinit var viewModel: ListItemViewModel
    private lateinit var repository: RepositoryImpl


    companion object {
        fun newInstance() = ListItemFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListItemBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRepositoryAndViewModel()



        changeEnableFavoriteItem()


    }

    private fun setUpRepositoryAndViewModel() {
        repository = RepositoryImpl
        val factory = ListItemViewModelFactory(repository)

        viewModel = ViewModelProvider(this, factory).get(ListItemViewModel::class.java)
    }

    fun changeEnableFavoriteItem() {
        val iconFavoriteOff: Drawable? = ContextCompat.getDrawable(requireContext(), R.drawable.heartdisabledpng)
        val iconFavoriteOn: Drawable? = ContextCompat.getDrawable(requireContext(), R.drawable.heartenabledpng)

        val imgFavorite = binding.iconFavourite
        imgFavorite.setOnClickListener {
            imgFavorite.setImageDrawable(iconFavoriteOn)
        }


    }




}