package com.huynguyen.realestate.data.network.model

import androidx.annotation.Keep
import com.google.gson.JsonObject

@Keep
data class ListingResponse(
    val id: String,
    val offerType: String,
    val address: AddressResponse,
    val categories: List<String>,
    val characteristics: CharacteristicsResponse,
    val prices: PriceResponse,
    val lister: ListerResponse,
    val localization: JsonObject,
    var propertyDetail: PropertyDetailResponse
)
