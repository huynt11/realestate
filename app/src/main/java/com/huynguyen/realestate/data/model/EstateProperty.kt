package com.huynguyen.realestate.data.model

import androidx.annotation.Keep

@Keep
data class EstateProperty(
    val id: String,
    val name: String,
    val price: String,
    val location: String,
    var isLiked: Boolean,
    var image: String
)
