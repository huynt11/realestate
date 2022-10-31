package com.huynguyen.realestate.data.mapper

import com.huynguyen.realestate.data.getEstateProperty
import com.huynguyen.realestate.data.getPropertyResponse
import com.huynguyen.realestate.data.model.EstateProperty
import org.junit.Test

class EstateMapperTest {

    @Test
    fun `verify mapper PropertyResponse to EstateProperty correctly`(){
        val propertyResponse = getPropertyResponse()
        val expectProperty = getEstateProperty()
        val actualProperty = propertyResponse.toEstateDetail()

        assert(expectProperty.id == actualProperty.id)
        assert(expectProperty.price == actualProperty.price)
        assert(expectProperty.location == actualProperty.location)
        assert(expectProperty.image == actualProperty.image)
    }
}