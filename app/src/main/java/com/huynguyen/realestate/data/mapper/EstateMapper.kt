package com.huynguyen.realestate.data.mapper

import com.google.gson.Gson
import com.huynguyen.realestate.data.model.EstateProperty
import com.huynguyen.realestate.data.network.model.PropertyDetailResponse
import com.huynguyen.realestate.data.network.model.PropertyResponse

fun PropertyResponse.toEstateDetail(): EstateProperty {
    val address = this.listing.address
    val price = this.listing.prices
    val detail = this.listing.localization
    val primary = detail.get("primary").asString
    val localizeDetail = detail.get(primary).toString()
    val localizeObject = Gson().fromJson(localizeDetail, PropertyDetailResponse::class.java)
    val image = localizeObject.attachments.first {
        it.type == "IMAGE"
    }.url
    return EstateProperty(
        id = this.id,
        price = "${price.currency} ${price.buy.price}",
        location = "${address.street} ${address.locality} ${address.region} ${address.postalCode}",
        name = localizeObject.text.title,
        isLiked = false,
        image = image
    )
}
