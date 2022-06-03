package com.example.moviesapp.menu.search.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.moviesapp.databinding.FragmentMovieBinding
import com.squareup.picasso.Picasso

class MovieFragment : Fragment() {

    private val args: MovieFragmentArgs by navArgs()
    lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //String strMeatFormat = getResources().getString(R.string.meatShootingMessage, numPoundsMeat);
        binding.tvMovieTitle.text = args.movieName
        binding.tvGenre.text = args.movieGenre
        binding.tvReleaseDate.text = args.releaseDate
        binding.tvSynopsis.text = args.synopsis
        binding.tvMovieOriginalTitle.text = args.movieName+" (Original Title)"
        binding.tvScore.text = args.score
        Picasso.get().load(args.posterURL).into(binding.imMoviePoster)
    }
}