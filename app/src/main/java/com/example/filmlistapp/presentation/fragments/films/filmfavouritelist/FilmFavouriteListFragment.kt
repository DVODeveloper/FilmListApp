package com.example.filmlistapp.presentation.fragments.films.filmfavouritelist

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmlistapp.R
import com.example.filmlistapp.data.repositoryimpl.RepositoryImpl
import com.example.filmlistapp.databinding.FragmentFilmFavouriteListBinding
import com.example.filmlistapp.databinding.FragmentFilmListBinding
import com.example.filmlistapp.presentation.fragments.films.filmlist.FilmListViewModel
import com.example.filmlistapp.presentation.fragments.films.filmlist.FilmListViewModelFactory
import com.example.filmlistapp.presentation.rvadapter.TestAdapter
import com.example.filmlistapp.presentation.rvadapter.TestAdapterFavourite

class FilmFavouriteListFragment : Fragment() {

    private lateinit var adapterFavourite: TestAdapterFavourite
    private lateinit var binding: FragmentFilmFavouriteListBinding
    private lateinit var viewModel: FilmFavouriteListViewModel
    private lateinit var repository: RepositoryImpl

    companion object {
        fun newInstance() = FilmFavouriteListFragment()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilmFavouriteListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRepositoryAndViewModel()                   //Валидируем репозиторий и вьюмодель
        setUpAdapter()                                  // Устанавливаем адаптер
        observeTestFavouriteListFromViewModel()         // Подписываемся на список получаемых item'ов



    }

    fun setUpRepositoryAndViewModel() {
        repository = RepositoryImpl
        val factory = FilmFavouriteListViewModelFactory(repository)

        viewModel = ViewModelProvider(this, factory).get(FilmFavouriteListViewModel::class.java)
    }

    fun setUpAdapter() {
        adapterFavourite = TestAdapterFavourite(this)
        binding.rcViewFavorite.layoutManager = LinearLayoutManager(context)
        binding.rcViewFavorite.adapter = adapterFavourite

    }

    fun observeTestFavouriteListFromViewModel() {
        viewModel.testFavouriteList.observe(viewLifecycleOwner) { testFavouriteList ->
            try {
                adapterFavourite.submitList(testFavouriteList)
                Log.d("FilmFavouriteListFragment", testFavouriteList.toString())
            } catch (e: Exception) {
                Log.d("FilmFavouriteListFragment", e.toString())
            }
        }
        viewModel.getTestFavouriteList()
    }
}