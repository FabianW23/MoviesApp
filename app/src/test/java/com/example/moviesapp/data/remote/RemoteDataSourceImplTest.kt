package com.example.moviesapp.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviesapp.data.datasource.remote.RemoteDataSource
import com.example.moviesapp.data.datasource.remote.RemoteDataSourceImpl
import com.example.moviesapp.data.datasource.remote.network.api.MovieApi
import com.example.moviesapp.data.model.dto.MovieCollectionDTO
import com.example.moviesapp.data.model.dto.MovieDTO
import com.example.moviesapp.data.model.dto.TopRatedCollectionDTO
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
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class RemoteDataSourceImplTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private var testCoroutineDispatcher = TestCoroutineDispatcher()

    @MockK
    lateinit var api: MovieApi

    @InjectMockKs
    private lateinit var remoteDataSource: RemoteDataSourceImpl

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `getTopRatedMovies should call movieApi getTopRatedMovies()`() =
        runBlockingTest {
        // Given
        val expectedResult = listOf<MovieDTO>()

        coEvery { api.getTopRatedMovies().results } returns expectedResult

        // When
        remoteDataSource.getTopRatedMovies()

        // Then
        coVerify { api.getTopRatedMovies().results }
    }

    @Test
    fun `getMovies should call movieApi getMovies()`() =
        runBlockingTest {
        // Given
        val expectedResult = listOf<MovieDTO>()

        coEvery { api.getCollectionMovies().items } returns expectedResult

        // When
        remoteDataSource.getMovies()

        // Then
        coVerify { api.getCollectionMovies().items }
    }
}