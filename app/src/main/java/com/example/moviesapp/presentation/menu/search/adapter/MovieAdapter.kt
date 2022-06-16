package com.example.moviesapp.presentation.menu.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentSearchBinding
import com.example.moviesapp.databinding.MovieRowItemBinding
import com.example.moviesapp.presentation.menu.search.SearchFragmentDirections
import com.example.moviesapp.domain.model.MovieModel
import com.squareup.picasso.Picasso

class MovieAdapter(val movie:List<MovieModel>):RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    lateinit var binding: MovieRowItemBinding

    inner class MovieHolder(val view:View):RecyclerView.ViewHolder(view), View.OnClickListener{

        //private val tvMovie:TextView = view.findViewById(R.id.tvMovie)
        //private val tvDate:TextView = view.findViewById(R.id.tvDate)
        //private val tvActors:TextView = view.findViewById(R.id.tvActors)
        //private val imPoster:ImageView = view.findViewById(R.id.imPoster)

        fun render(movie: MovieModel){
            binding.tvMovie.text = movie.name
            binding.tvDate.text = movie.date
            binding.tvActors.text = movie.actors
            Picasso.get().load(movie.poster).into(binding.imPoster)
            view.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            var action = SearchFragmentDirections.actionSearchFragmentToMovieFragment(movie[layoutPosition])
            view?.findNavController()?.navigate(action)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = MovieRowItemBinding.inflate(layoutInflater,parent,false)
        return MovieHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.render(movie[position])
    }

    override fun getItemCount(): Int {
        return movie.size
    }
}