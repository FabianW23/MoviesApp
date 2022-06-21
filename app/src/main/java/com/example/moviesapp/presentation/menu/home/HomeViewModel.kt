package com.example.moviesapp.presentation.menu.home;

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.domain.usecase.GetMoviesUseCase
import com.example.moviesapp.domain.usecase.GetTopRatedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase): ViewModel() {

    val movieList : MutableLiveData<List<MovieModel>> = MutableLiveData()

    fun getMovies(){
        viewModelScope.launch(Dispatchers.IO) {
            val listMovies = getTopRatedMoviesUseCase()
            movieList.postValue(listMovies)
        }
    }

}
