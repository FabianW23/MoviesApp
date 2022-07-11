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
        binding.topAppBar.title = args.movie.title
        binding.tvMovieTitle.text = args.movie.title
        binding.tvGenre.text = "NA" //args.movie.genre
        binding.tvReleaseDate.text = args.movie.mediaType + " " + args.movie.releaseDate
        binding.tvSynopsis.text = args.movie.overview
        binding.tvMovieOriginalTitle.text = args.movie.originalTitle+ resources.getString(R.string.original_title)
        binding.tvScore.text = args.movie.voteAverage.toString()
        Picasso.get().load(args.movie.posterUrlPath).into(binding.imMoviePoster)
        Picasso.get().load(args.movie.BackDropPath).into(binding.imMovieTrailer)
    }
}