package com.example.moviesapp.presentation.menu.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.presentation.di.IoDispatcher
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.domain.usecase.movie.GetTopRatedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    @IoDispatcher private val dispatcher: CoroutineDispatcher): ViewModel() {

    val movieList : MutableLiveData<List<MovieModel>> = MutableLiveData()

    fun getTopRatedMovies(){
        viewModelScope.launch(dispatcher) {
            val listMovies = getTopRatedMoviesUseCase()
            movieList.postValue(listMovies)
        }
    }

}

