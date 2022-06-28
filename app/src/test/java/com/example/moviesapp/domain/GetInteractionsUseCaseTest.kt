package com.example.moviesapp.domain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviesapp.domain.model.InteractionModel
import com.example.moviesapp.domain.repository.InteractionRepository
import com.example.moviesapp.domain.usecase.GetInteractionsUseCase
import com.example.moviesapp.domain.usecase.impl.GetInteractionsUseCaseImpl
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
class GetInteractionsUseCaseTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private var testCoroutineDispatcher = TestCoroutineDispatcher()

    @MockK
    lateinit var interactionRepository: InteractionRepository

    @InjectMockKs
    private lateinit var getInteractionsUseCaseImpl: GetInteractionsUseCaseImpl

    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }

    @Test
    fun `getInteractionsUseCaseImpl should call interactionRepository getInteractions()`() =
        runBlockingTest {
            // Given
            val expectedResult = listOf(mockk<InteractionModel>())

            coEvery { interactionRepository.getInteractions() } returns expectedResult

            // When
            getInteractionsUseCaseImpl.invoke()

            // Then
            coVerify{interactionRepository.getInteractions()}
        }
}