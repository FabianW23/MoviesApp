package com.example.moviesapp.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviesapp.data.datasource.cache.CacheDataSource
import com.example.moviesapp.data.datasource.remote.RemoteDataSource
import com.example.moviesapp.data.mapper.toListOfInteractionModel
import com.example.moviesapp.data.mapper.toListOfMovieModel
import com.example.moviesapp.data.repository.InteractionRepositoryImpl
import com.example.moviesapp.data.repository.MovieRepositoryImpl
import com.example.moviesapp.domain.model.InteractionModel
import com.example.moviesapp.domain.model.MovieModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieRepositoryImplTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private var testCoroutineDispatcher = TestCoroutineDispatcher()

    @MockK
    lateinit var remoteDataSource: RemoteDataSource

    @InjectMockKs
    private lateinit var movieRepositoryImpl: MovieRepositoryImpl

    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }

    @Test
    fun `movieRepositoryImpl getMovies should call remoteDataSource getMovies() toListOfMovieModel()`() =
        runBlockingTest {
            // Given
            val expectedResult = listOf<MovieModel>()
            coEvery { remoteDataSource.getMovies().toListOfMovieModel() } returns expectedResult

            // When
            movieRepositoryImpl.getMovies()

            // Then
            coVerify{remoteDataSource.getMovies().toListOfMovieModel()}
        }

    @Test
    fun `movieRepositoryImpl getTopRatedMovies should call remoteDataSource getTopRatedMovies() toListOfMovieModel()`() =
        runBlockingTest {
            // Given
            val expectedResult = listOf<MovieModel>()
            coEvery { remoteDataSource.getTopRatedMovies().toListOfMovieModel() } returns expectedResult

            // When
            movieRepositoryImpl.getTopRatedMovies()

            // Then
            coVerify{remoteDataSource.getTopRatedMovies().toListOfMovieModel()}
        }
}