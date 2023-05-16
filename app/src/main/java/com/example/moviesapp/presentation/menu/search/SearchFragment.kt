package com.example.moviesapp.presentation.menu.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.moviesapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import coil.compose.rememberAsyncImagePainter
import com.example.moviesapp.databinding.FragmentSearchBinding
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.presentation.theme.LightGrayCustom
import com.example.moviesapp.presentation.theme.YellowDark
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel : SearchViewModel by viewModels()
    private lateinit var moviesColumView: ComposeView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.getMovies()
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        moviesColumView = binding.rvMoviesCompose
        moviesColumView.setContent {
            Content( viewModel, this)
        }
        return binding.root
    }
}

@Composable
private fun Content( viewModel: SearchViewModel, binding: SearchFragment) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchField(viewModel, context)
        MoviesList(viewModel, binding)
    }
}

@Composable
private fun SearchField(viewModel: SearchViewModel, context: Context) {
    val query by viewModel.query.observeAsState(initial = "")
    Box(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 16.dp)
            .background(Color.White)
    ) {
        TextField(
            placeholder = { (Text(text = context.getString(R.string.search))) },
            value = query,
            onValueChange = {
                viewModel.onQueryChanged(it)
            },
            shape = RoundedCornerShape(10.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = context.getString(R.string.search),
                    tint = Color.DarkGray
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = YellowDark,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = LightGrayCustom,
                placeholderColor = Color.Black,
                cursorColor = YellowDark,
                disabledPlaceholderColor = Color.DarkGray
            )
        )
    }
}

@Composable
private fun MoviesList(viewModel: SearchViewModel, binding: SearchFragment) {
    val movies by viewModel.movieList.observeAsState(listOf())
    val listState = rememberLazyListState()
    LazyColumn(
        state = listState,
        modifier = Modifier
            .background(color = Color(0xFFF5F5F5))
            .fillMaxSize(1F)
    ) {
        items(movies) { movie: MovieModel ->
            MovieItem(movie = movie, binding)
        }
    }
}

@Composable
private fun MovieItem(movie : MovieModel, binding: SearchFragment) {

    Card(modifier = Modifier.clickable {
        val action = SearchFragmentDirections.actionSearchFragmentToMovieFragment(movie)
        NavHostFragment.findNavController(binding).navigate(action)
    }) {
        Row(modifier = Modifier.background(color = Color(0xFFF5F5F5))) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = movie.posterUrlPath
                ),
                contentDescription = "movie poster",
                modifier = Modifier
                    .size(height = 120.dp, width = 80.dp)
                    .padding(top = 8.dp, bottom = 8.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp)
            ) {
                Text(text = movie.title)
                Text(
                    text = movie.releaseDate,
                    textAlign = TextAlign.Center
                )
                Text(text = movie.originalTitle)
            }
        }
        Divider(modifier = Modifier.background(color = Color(0xFFE6E6E6)))
    }
}

fun showMessage(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}