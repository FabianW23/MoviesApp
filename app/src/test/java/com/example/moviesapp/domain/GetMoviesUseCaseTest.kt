package com.example.moviesapp.domain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviesapp.domain.model.InteractionModel
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.domain.repository.InteractionRepository
import com.example.moviesapp.domain.repository.MovieRepository
import com.example.moviesapp.domain.usecase.impl.GetInteractionsUseCaseImpl
import com.example.moviesapp.domain.usecase.impl.GetMoviesUseCaseImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GetMoviesUseCaseTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private var testCoroutineDispatcher = TestCoroutineDispatcher()

    @MockK
    lateinit var movieRepository: MovieRepository

    @InjectMockKs
    private lateinit var getMoviesUseCaseImpl: GetMoviesUseCaseImpl

    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }

    @Test
    fun `getInteractionsUseCaseImpl should call interactionRepository getInteractions()`() =
        runBlockingTest {
            // Given
            val expectedResult = listOf(mockk<MovieModel>())

            coEvery { movieRepository.getMovies() } returns expectedResult

            // When
            getMoviesUseCaseImpl.invoke()

            // Then
            coVerify{movieRepository.getMovies()}
        }
}