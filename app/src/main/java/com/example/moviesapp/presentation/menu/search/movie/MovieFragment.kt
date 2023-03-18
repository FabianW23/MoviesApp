package com.example.moviesapp.presentation.menu.search.movie

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentMovieBinding
import com.example.moviesapp.domain.model.MovieModel
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
        binding.shareMovie.setOnClickListener {
            startLocationPermissionRequest()
        }
        return binding.root
    }

    private val requestPermissionLauncher = this.registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            navigateToSharePage()
        } else {
            Toast.makeText(context, "Read contacts permission needed", Toast.LENGTH_LONG).show()
        }
    }

    // Ex. Launching ACCESS_FINE_LOCATION permission.
    private fun startLocationPermissionRequest() {
        requestPermissionLauncher.launch(Manifest.permission.READ_CONTACTS)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.topAppBar.title = args.movie.title
        binding.tvMovieTitle.text = args.movie.title
        binding.tvGenre.text = context?.getString(R.string.drama)
        binding.tvReleaseDate.text = args.movie.mediaType + " " + args.movie.releaseDate
        binding.tvSynopsis.text = args.movie.overview
        binding.tvMovieOriginalTitle.text = args.movie.originalTitle+ resources.getString(R.string.original_title)
        binding.tvScore.text = args.movie.voteAverage.toString()
        Picasso.get().load(args.movie.posterUrlPath).into(binding.imMoviePoster)
        Picasso.get().load(args.movie.BackDropPath).into(binding.imMovieTrailer)


    }

    private fun navigateToSharePage(){
        val action = MovieFragmentDirections.actionMovieFragmentToShareMovieFragment(args.movie)
        NavHostFragment.findNavController(this).navigate(action)
    }
}