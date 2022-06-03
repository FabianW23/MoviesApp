package com.example.moviesapp.menu.search.adapter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentSearchBinding
import com.example.moviesapp.menu.search.SearchFragmentDirections
import com.example.moviesapp.menu.search.model.Movie
import com.squareup.picasso.Picasso

class MovieAdapter(val movie:List<Movie>):RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    lateinit var binding: FragmentSearchBinding

    inner class MovieHolder(val view:View):RecyclerView.ViewHolder(view), View.OnClickListener{

        private val tvMovie:TextView = view.findViewById(R.id.tvMovie)
        private val tvDate:TextView = view.findViewById(R.id.tvDate)
        private val tvActors:TextView = view.findViewById(R.id.tvActors)
        private val imPoster:ImageView = view.findViewById(R.id.imPoster)

        fun render(movie:Movie){
            tvMovie.text = movie.name
            tvDate.text = movie.date
            tvActors.text = movie.actors
            Picasso.get().load(movie.poster).into(imPoster)
        }

        override fun onClick(view: View?) {
            val position = layoutPosition
            val movieName = this.tvMovie.text.toString()
            val poster = movie[position].poster
            val synopsis = movie[position].synopsis
            val movieGenre = movie[position].genre
            val date = movie[position].date
            val score = movie[position].score.toString()

            var action = SearchFragmentDirections.actionSearchFragmentToMovieFragment(movieName,poster,synopsis,movieGenre, date, score)
            view?.findNavController()?.navigate(action)
        }
        init {
            view.setOnClickListener(this)
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