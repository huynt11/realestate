package com.huynguyen.realestate.data.network.model

import androidx.annotation.Keep

@Keep
data class ListerBrandingResponse(
    val logoUrl: String,
    val legalName: String,
    val name: String,
    val address: AddressResponse,
    val adActive: Boolean,
    val isQualityPartner: Boolean,
    val isPremiumBranding: Boolean,
    val profilePageUrlKeyword: String
)
