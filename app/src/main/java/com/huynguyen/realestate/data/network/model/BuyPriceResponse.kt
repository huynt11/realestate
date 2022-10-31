package com.huynguyen.realestate.data.network.model

import androidx.annotation.Keep

@Keep
data class BuyPriceResponse(
    val area: String,
    val price: Float,
    val interval: String
)
