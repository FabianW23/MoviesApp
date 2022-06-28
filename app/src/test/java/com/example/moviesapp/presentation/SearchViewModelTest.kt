package com.example.moviesapp.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.domain.usecase.GetMoviesUseCase
import com.example.moviesapp.domain.usecase.GetTopRatedMoviesUseCase
import com.example.moviesapp.presentation.menu.home.HomeViewModel
import com.example.moviesapp.presentation.menu.search.SearchViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private var testCoroutineDispatcher = TestCoroutineDispatcher()

    @MockK
    lateinit var getMoviesUseCase: GetMoviesUseCase

    @InjectMockKs
    private lateinit var viewModel: SearchViewModel

    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }

    @Test
    fun `getMovies should call getMoviesUseCase()`() =
        runBlockingTest {
            // Given
            val expectedResult = listOf(mockk<MovieModel>())

            coEvery { getMoviesUseCase() } returns expectedResult

            // When
            viewModel.getMovies()

            // Then
            coVerify { getMoviesUseCase() }
        }

    @Test
    fun `getMovies emit movie list with data status through a liveData when getMoviesUseCase()`(){
        // Given
        val expectedResult = listOf(mockk<MovieModel>())

        coEvery { getMoviesUseCase() } returns expectedResult

        // When
        viewModel.getMovies()
        var result = viewModel.movieList.value

        // Then
        assertEquals(expectedResult,result)
    }
}