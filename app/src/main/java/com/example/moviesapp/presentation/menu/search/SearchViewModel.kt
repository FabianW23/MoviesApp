package com.example.moviesapp.presentation.menu.search

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

     val movieList : MutableLiveData<List<MovieModel>> by lazy {
        MutableLiveData<List<MovieModel>>().also {
            getMovies()
        }
    }

    private var matchedMovieList = listOf<MovieModel>()
    val query = MutableLiveData("")

    fun getMovies(){
        viewModelScope.launch(dispatcher) {
            matchedMovieList = getMoviesUseCase()
            movieList.postValue(matchedMovieList)
        }
    }

    fun onQueryChanged(query: String){
        this.query.value = query
        viewModelScope.launch(dispatcher){
            if(query.isEmpty()){
                movieList.postValue(matchedMovieList)
            }else{
                movieList.postValue( matchedMovieList.filter { it.title.contains(query, ignoreCase = true) } )
            }
        }

    }
}
