package com.example.moviesapp.presentation.menu.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ProfileDataItemBinding
import com.example.moviesapp.databinding.TopMovieItemBinding
import com.example.moviesapp.domain.model.MovieModel
import com.squareup.picasso.Picasso

class MovieTopAdapter(private val movie:List<MovieModel>):RecyclerView.Adapter<MovieTopAdapter.MovieHolder>() {

    private lateinit var binding: TopMovieItemBinding

    inner class MovieHolder(val view:View):RecyclerView.ViewHolder(view){

        fun render(movie: MovieModel){
            binding.tvNameTop.text = movie.title
            binding.tvScore.text = movie.voteAverage.toString()
            Picasso.get().load(movie.posterUrlPath).into(binding.imPosterTop)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = TopMovieItemBinding.inflate(layoutInflater,parent,false)
        return MovieHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.render(movie[position])
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return movie.size
    }
}