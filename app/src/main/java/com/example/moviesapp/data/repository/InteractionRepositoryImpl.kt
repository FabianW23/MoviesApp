package com.example.moviesapp.data.repository

import com.example.moviesapp.data.datasource.cache.CacheDataSource
import com.example.moviesapp.data.mapper.toListOfInteractionModel
import com.example.moviesapp.domain.model.InteractionModel
import com.example.moviesapp.domain.repository.InteractionRepository
import javax.inject.Inject

class InteractionRepositoryImpl @Inject constructor(private val cacheDataSource: CacheDataSource) : InteractionRepository{
    override fun getInteractions():List<InteractionModel>{
        return cacheDataSource.getInteractions().toListOfInteractionModel()
    }
}