package com.huynguyen.realestate.data.network.model

import androidx.annotation.Keep
import com.google.gson.JsonObject

@Keep
data class PropertyDetailResponse(
    val attachments: List<AttachmentResponse>,
    val text: PropertyTextResponse,
)
