package com.huynguyen.realestate.data.network.model

import androidx.annotation.Keep

@Keep
data class GeoCoordinatesResponse(
    val latitude: String,
    val longitude: String,
)
