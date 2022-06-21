package com.example.moviesapp.presentation.menu.search;

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.domain.usecase.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val getMoviesUseCase: GetMoviesUseCase): ViewModel() {

    val movieList : MutableLiveData<List<MovieModel>> = MutableLiveData()

    fun getMovies(){
        viewModelScope.launch(Dispatchers.IO) {
            val listMovies = getMoviesUseCase()
            movieList.postValue(listMovies)
        }
    }

}