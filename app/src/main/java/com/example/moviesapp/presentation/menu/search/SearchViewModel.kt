package com.example.moviesapp.presentation.menu.search;

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.presentation.di.IoDispatcher
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.domain.usecase.movie.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    @IoDispatcher private val dispatcher: CoroutineDispatcher): ViewModel() {

    val movieList : MutableLiveData<List<MovieModel>> = MutableLiveData()

    fun getMovies(){
        viewModelScope.launch(dispatcher) {
            val listMovies = getMoviesUseCase()
            movieList.postValue(listMovies)
        }
    }
}
