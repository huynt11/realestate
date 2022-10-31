package com.huynguyen.realestate.data.repository

import com.huynguyen.realestate.base.BaseNetworkResult
import com.huynguyen.realestate.data.local.LocalDataSource
import com.huynguyen.realestate.data.mapper.toEstateDetail
import com.huynguyen.realestate.data.model.EstateProperty
import com.huynguyen.realestate.data.network.services.EstateService
import com.huynguyen.realestate.extention.runNetworkSafety
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EstateRepositoryImpl @Inject constructor(
    private val estateService: EstateService,
    private val localDataSource: LocalDataSource
) :  EstateRepository{

    override suspend fun getProperties(): Flow<BaseNetworkResult<List<EstateProperty>>> {
        return flow {
            val result = getPropertiesFromNetwork()
            emit(result)
        }
    }

    override suspend fun saveFavorite(id: String) {
        localDataSource.saveFavorite(id)
    }

    override suspend fun removeFavorite(id: String) {
        localDataSource.removeFavorite(id)
    }


    private suspend fun getPropertiesFromNetwork(): BaseNetworkResult<List<EstateProperty>> {
        return runNetworkSafety {
            val response = estateService.getEstateList()
            val favorite = localDataSource.getFavorites()
            val weatherInfoListResponse = response.results.map {
                it.toEstateDetail().apply {
                    this.isLiked = favorite.contains(this.id)
                }
            }
            BaseNetworkResult.Success(weatherInfoListResponse)
        }
    }
}