package com.huynguyen.realestate.data.network.services

import com.huynguyen.realestate.data.network.model.GetEstateResponse
import retrofit2.http.GET

interface EstateService {
    @GET("/properties")
    suspend fun getEstateList(): GetEstateResponse
}