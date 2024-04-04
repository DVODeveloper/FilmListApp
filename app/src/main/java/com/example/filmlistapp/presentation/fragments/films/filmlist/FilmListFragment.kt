package com.example.filmlistapp.presentation.fragments.films.filmlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmlistapp.data.repositoryimpl.RepositoryImpl
import com.example.filmlistapp.databinding.FragmentFilmListBinding
import com.example.filmlistapp.presentation.rvadapter.TestAdapter

class FilmListFragment : Fragment() {
    private lateinit var adapter: TestAdapter
    private lateinit var binding: FragmentFilmListBinding
    private lateinit var viewModel: FilmListViewModel
    private lateinit var repository: RepositoryImpl

    private var count = 0

    companion object {
        fun newInstance() = FilmListFragment()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilmListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRepositoryAndViewModel() //Валидируем репозиторий и вьюмодель
        setUpAdapter() // Устанавливаем адаптер
        observeTestListFromViewModel() // Подписываемся на список получаемых item'ов
        viewModel.testList.observe(viewLifecycleOwner) {
            Log.d("FilmListFragment1", "${it.size}")
        }
        viewModel.getTestList()
        adapter.onFavouriteIconClickListener = {

            Log.d("FilmListFragment", it.toString())
        }

    }


    fun setUpRepositoryAndViewModel() {
        repository = RepositoryImpl
        val factory = FilmListViewModelFactory(repository)

        viewModel = ViewModelProvider(this, factory).get(FilmListViewModel::class.java)
    }

    fun setUpAdapter() {
        adapter = TestAdapter(this)
        binding.rcView.layoutManager = LinearLayoutManager(context)
        binding.rcView.adapter = adapter

//        adapter
    }

    fun observeTestListFromViewModel() {
        viewModel.testList.observe(viewLifecycleOwner) { testList ->
            try {
                adapter.submitList(testList)
                adapter.onFavouriteIconClickListener = {
                    viewModel.changeEnableState(it)
                }
                Log.d("FilmListFragment", testList.toString())
            } catch (e: Exception) {
                Log.d("FilmListFragment", e.toString())
            }
        }
        viewModel.getTestList()

    }




}