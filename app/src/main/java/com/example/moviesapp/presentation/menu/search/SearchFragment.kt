package com.example.moviesapp.presentation.menu.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.databinding.FragmentSearchBinding
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.presentation.menu.search.adapter.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel : SearchViewModel by viewModels()
    private lateinit var movies : List<MovieModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.movieList.observe(this, Observer(::setMovieList))
    }

    private fun initRecycler(){
        binding.rvMovies.layoutManager = LinearLayoutManager(context)
        var adapter = MovieAdapter(movies)
        binding.rvMovies.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMovies()
    }

    private fun setMovieList(movies: List<MovieModel>?) {
        if (movies != null) {
            this.movies = movies
            initRecycler()
        }
    }
}