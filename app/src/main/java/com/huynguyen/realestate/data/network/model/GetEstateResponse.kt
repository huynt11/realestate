package com.huynguyen.realestate.data.network.model

import androidx.annotation.Keep

@Keep
data class GetEstateResponse(
    val from: Int,
    val size: Int,
    val total: Int,
    val maxFrom: Int,
    val results: List<PropertyResponse>
)
