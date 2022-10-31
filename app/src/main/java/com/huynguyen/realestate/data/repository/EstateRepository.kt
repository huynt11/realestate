package com.huynguyen.realestate.data.repository

import com.huynguyen.realestate.base.BaseNetworkResult
import com.huynguyen.realestate.data.model.EstateProperty
import kotlinx.coroutines.flow.Flow

interface EstateRepository {
    suspend fun getProperties(): Flow<BaseNetworkResult<List<EstateProperty>>>
    suspend fun saveFavorite(id: String)
    suspend fun removeFavorite(id: String)
}