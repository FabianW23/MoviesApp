package com.example.moviesapp.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviesapp.data.datasource.cache.CacheDataSource
import com.example.moviesapp.data.mapper.toListOfInteractionModel
import com.example.moviesapp.data.repository.InteractionRepositoryImpl
import com.example.moviesapp.domain.model.InteractionModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class InteractionRepositoryTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var cacheDataSource: CacheDataSource

    @InjectMockKs
    private lateinit var interactionRepositoryImpl: InteractionRepositoryImpl

    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }

    @Test
    fun `interactionRepositoryImpl getInteractions should call cacheDataSource getInteractions() toListOfInteractionModel()`() =
        runBlockingTest {
            // Given
            val expectedResult = listOf<InteractionModel>()
            coEvery { cacheDataSource.getInteractions().toListOfInteractionModel() } returns expectedResult

            // When
            interactionRepositoryImpl.getInteractions()

            // Then
            coVerify{cacheDataSource.getInteractions().toListOfInteractionModel()}
        }
}