package com.huynguyen.realestate.data.network.model

import androidx.annotation.Keep

@Keep
data class PropertyResponse(
    val id: String,
    val remoteViewing: Boolean,
    val listingType: ListingTypeResponse,
    val listerBranding: ListerBrandingResponse,
    val listing: ListingResponse
)
