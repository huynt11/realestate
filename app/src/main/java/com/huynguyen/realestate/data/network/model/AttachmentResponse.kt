package com.huynguyen.realestate.data.network.model

import androidx.annotation.Keep

@Keep
data class AttachmentResponse(
    val type: String,
    val url: String,
    val file: String
)
