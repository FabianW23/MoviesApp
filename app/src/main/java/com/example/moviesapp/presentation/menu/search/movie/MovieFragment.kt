package com.example.moviesapp.presentation.menu.search.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentMovieBinding
import com.squareup.picasso.Picasso

class MovieFragment : Fragment() {

    private val args: MovieFragmentArgs by navArgs()
    lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        binding.topAppBar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.topAppBar.title = args.movie.name
        binding.tvMovieTitle.text = args.movie.name
        binding.tvGenre.text = args.movie.genre
        binding.tvReleaseDate.text = args.movie.date
        binding.tvSynopsis.text = args.movie.synopsis
        binding.tvMovieOriginalTitle.text = args.movie.name+ resources.getString(R.string.original_title)
        binding.tvScore.text = args.movie.score.toString()
        Picasso.get().load(args.movie.poster).into(binding.imMoviePoster)
    }
}