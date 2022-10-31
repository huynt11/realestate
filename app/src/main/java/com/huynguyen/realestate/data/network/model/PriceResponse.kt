package com.huynguyen.realestate.data.network.model

import androidx.annotation.Keep

@Keep
data class PriceResponse(
    val currency: String,
    val buy: BuyPriceResponse
)
