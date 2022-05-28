package com.example.moviesapp.menu.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.menu.search.model.Movie
import com.squareup.picasso.Picasso

class MovieAdapter(val movie:List<Movie>):RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    class MovieHolder(val view:View):RecyclerView.ViewHolder(view){

        val tvMovie:TextView
        val tvDate:TextView
        val tvActors:TextView
        val imPoster:ImageView

        init {
            tvMovie = view.findViewById(R.id.tvMovie)
            tvDate = view.findViewById(R.id.tvDate)
            tvActors = view.findViewById(R.id.tvActors)
            imPoster = view.findViewById(R.id.imPoster)
        }

        fun render(movie:Movie){
            tvMovie.text = movie.name
            tvDate.text = movie.date
            tvActors.text = movie.actors
            Picasso.get().load(movie.poster).into(imPoster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieHolder(layoutInflater.inflate(R.layout.movie_row_item, parent, false))
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.render(movie[position])
    }

    override fun getItemCount(): Int {
        return movie.size
    }
}