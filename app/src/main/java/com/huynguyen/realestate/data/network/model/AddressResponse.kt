package com.huynguyen.realestate.data.network.model

import androidx.annotation.Keep

@Keep
data class AddressResponse(
    val locality: String,
    val country: String,
    val region: String,
    val street: String,
    val postalCode: String,
    val geoCoordinates: GeoCoordinatesResponse
)
