package com.example.moviesapp.presentation.menu.search

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import coil.compose.rememberAsyncImagePainter
import com.example.moviesapp.data.model.dto.MovieDTO
import com.example.moviesapp.databinding.FragmentSearchBinding
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.presentation.menu.play.getMovies
import com.example.moviesapp.presentation.menu.search.adapter.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel : SearchViewModel by viewModels()
    private lateinit var movies : List<MovieModel>
    private lateinit var adapter : MovieAdapter
    private lateinit var moviesColumView: ComposeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.movieList.observe(this, Observer(::setMovieList))
    }

    private fun initRecycler(){
        //binding.rvMovies.layoutManager = LinearLayoutManager(context)
        //adapter = MovieAdapter(movies)
        //binding.rvMovies.adapter = adapter
        moviesColumView = binding.rvMoviesCompose
        setMoviesToListView(movies)
    }

    private fun setMoviesToListView(moviesList : List<MovieModel>){
        moviesColumView.setContent {
            moviesList(moviesList)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMovies()

        binding.svSearchMovie.setOnQueryTextListener(object : SearchView.OnQueryTextListener ,
            android.widget.SearchView.OnQueryTextListener {

            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextSubmit(query: String): Boolean {
                if (movies.any { movieModel -> movieModel.title.contains(query, ignoreCase = true) }) {
                    setMoviesToListView(movies.filter { it.title.contains(query, ignoreCase = true) })
                } else {
                    Toast.makeText(context, "No Match found", Toast.LENGTH_LONG).show()
                }
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                if (movies.any { movieModel -> movieModel.title.contains(query ?: "", ignoreCase = true) }) {
                    setMoviesToListView(movies.filter { it.title.contains(query ?: "", ignoreCase = true) })
                }
                return true
            }
        })
    }

    private fun setMovieList(movies: List<MovieModel>?) {
        if (movies != null) {
            this.movies = movies
            initRecycler()
        }
    }

    /*private fun filter(text: String) {
        // creating a new array list to filter our data.
        val filteredlist: ArrayList<MovieModel> = ArrayList()

        // running a for loop to compare elements.
        for (item in movies) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.title.toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(context, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter.filterList(filteredlist)
        }
    }*/
}

@Composable
private fun moviesList(movies: List<MovieModel>){
    val listState = rememberLazyListState()
    LazyColumn(state = listState,
        modifier = Modifier
            .background(color = Color(0xFFF5F5F5))
            .fillMaxSize(1F)){
        items(movies){ movie : MovieModel ->
            movieItem(movie = movie)

        }
    }
}

@Composable
private fun movieItem(movie: MovieModel){
    Card() {
        Row(modifier = Modifier.background(color = Color(0xFFF5F5F5))) {
            Image(painter = rememberAsyncImagePainter(
                model = movie.posterUrlPath),
                contentDescription = "movie poster",
                modifier = Modifier
                    .size(height = 120.dp, width = 80.dp)
                    .padding(top = 8.dp, bottom = 8.dp))
            Column(verticalArrangement = Arrangement.spacedBy(10.dp) ,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp)) {
                Text(text = movie.title.toString())
                Text(text = movie.releaseDate.toString(),
                    textAlign = TextAlign.Center)
                Text(text = movie.originalTitle)
            }

        }
        Divider(modifier = Modifier.background(color = Color(0xFFE6E6E6)))
    }
}