package com.example.moviesapp.presentation.menu.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.databinding.MovieRowItemBinding
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.presentation.menu.search.SearchFragmentDirections
import com.squareup.picasso.Picasso


class MovieAdapter(var movie:List<MovieModel>):RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    lateinit var binding: MovieRowItemBinding

    inner class MovieHolder(val view:View):RecyclerView.ViewHolder(view), View.OnClickListener{

        fun render(movie: MovieModel){
            binding.tvMovie.text = movie.title
            binding.tvDate.text = movie.releaseDate
            binding.tvActors.text = movie.title
            Picasso.get().load(movie.posterUrlPath).into(binding.imPoster)
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

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return movie.size
    }


}