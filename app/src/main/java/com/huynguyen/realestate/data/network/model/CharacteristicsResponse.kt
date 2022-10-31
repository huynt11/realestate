package com.huynguyen.realestate.data.network.model

import androidx.annotation.Keep

@Keep
data class CharacteristicsResponse(
    val numberOfRooms: Float,
    val livingSpace: Int,
    val lotSize: Int,
    val totalFloorSpace: Int
)
