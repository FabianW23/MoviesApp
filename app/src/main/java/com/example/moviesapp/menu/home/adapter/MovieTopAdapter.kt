package com.example.moviesapp.menu.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.menu.search.model.Movie
import com.squareup.picasso.Picasso

class MovieTopAdapter(val movie:List<Movie>):RecyclerView.Adapter<MovieTopAdapter.MovieHolder>() {

    class MovieHolder(val view:View):RecyclerView.ViewHolder(view){

        private val tvMovie:TextView = view.findViewById(R.id.tvNameTop)
        private val tvScore:TextView = view.findViewById(R.id.tvScore)
        private val imPoster:ImageView = view.findViewById(R.id.imPosterTop)

        fun render(movie:Movie){
            tvMovie.text = movie.name
            tvScore.text = movie.date
            Picasso.get().load(movie.poster).into(imPoster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieHolder(layoutInflater.inflate(R.layout.top_movie_item, parent, false))
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.render(movie[position])
    }

    override fun getItemCount(): Int {
        return movie.size
    }
}