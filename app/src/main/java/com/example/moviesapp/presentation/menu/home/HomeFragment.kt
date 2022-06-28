package com.example.moviesapp.presentation.menu.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.databinding.FragmentHomeBinding
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.presentation.menu.home.adapter.MovieTopAdapter
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel : HomeViewModel by viewModels()
    private lateinit var movies : List<MovieModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.movieList.observe(this, Observer(::setMovieList))
    }

    private fun initRecycler(){
        binding.rvTop.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        var adapter = MovieTopAdapter(movies)
        binding.rvTop.adapter = adapter
    }

    private fun initTrending(){
        val movie = movies[Random.nextInt(movies.size)]
        binding.tvTrendingMovieTitle.text = movie.title
        Picasso.get().load(movie.BackDropPath).into(binding.imTrendingMovieTrailer)
        Picasso.get().load(movie.posterUrlPath).into(binding.imTrendingMoviePoster)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTopRatedMovies()
    }

    private fun setMovieList(movies: List<MovieModel>?) {
        if (movies != null) {
            this.movies = movies
            initTrending()
            initRecycler() // Ahora aqui
        }
    }

}