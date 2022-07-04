package com.example.moviesapp.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.domain.usecase.movie.GetTopRatedMoviesUseCase
import com.example.moviesapp.presentation.menu.home.HomeViewModel
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
class HomeViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private var testCoroutineDispatcher = TestCoroutineDispatcher()

    @MockK
    lateinit var getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase

    @InjectMockKs
    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }

    @Test
    fun `getTopRatedMovies should call getTopRatedMoviesUseCase()`() =
        runBlockingTest {
            // Given
            val expectedResult = listOf(mockk<MovieModel>())

            coEvery { getTopRatedMoviesUseCase() } returns expectedResult

            // When
            viewModel.getTopRatedMovies()

            // Then
            coVerify { getTopRatedMoviesUseCase() }
        }

    @Test
    fun `getTopRatedMovies emit movie list with data status through a liveData when getTopRatedMoviesUseCase()`(){
        // Given
        val expectedResult = listOf(mockk<MovieModel>())

        coEvery { getTopRatedMoviesUseCase() } returns expectedResult

        // When
        viewModel.getTopRatedMovies()
        var result = viewModel.movieList.value

        // Then
        assertEquals(expectedResult,result)
    }
}