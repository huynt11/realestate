package com.huynguyen.realestate.data

import com.google.gson.Gson
import com.huynguyen.realestate.data.model.EstateProperty
import com.huynguyen.realestate.data.network.model.GetEstateResponse
import com.huynguyen.realestate.data.network.model.PropertyResponse

fun getPropertyResponse(): PropertyResponse {
    return getEstateResponse().results[0]
}

fun getEstateResponse(): GetEstateResponse {
    return Gson().fromJson(rawResponse, GetEstateResponse::class.java)
}

fun getEstateProperty() = EstateProperty(
    id = "104123262",
    name = "Luxuriöses Einfamilienhaus mit Pool - Musterinserat",
    location = "Musterstrasse 999 La Brévine NE 2406",
    price = "CHF 9999999.0",
    isLiked = false,
    image = "https://media2.homegate.ch/listings/heia/104123262/image/6b53db714891bfe2321cc3a6d4af76e1.jpg"
)


val rawResponse = "{\n" +
        "   \"from\":0,\n" +
        "   \"size\":100,\n" +
        "   \"total\":9,\n" +
        "   \"results\":[\n" +
        "      {\n" +
        "         \"id\":\"104123262\",\n" +
        "         \"remoteViewing\":false,\n" +
        "         \"listingType\":{\n" +
        "            \"type\":\"TOP\"\n" +
        "         },\n" +
        "         \"listerBranding\":{\n" +
        "            \"logoUrl\":\"https://media2.homegate.ch/t_customer_logo/logos/l_heia_v1.png\",\n" +
        "            \"legalName\":\"SMG Swiss Marketplace Group AG\",\n" +
        "            \"name\":\"Homegate\",\n" +
        "            \"address\":{\n" +
        "               \"locality\":\"Zürich\",\n" +
        "               \"country\":\"CH\",\n" +
        "               \"region\":\"ZH\",\n" +
        "               \"street\":\"Werdstrasse 21\",\n" +
        "               \"postalCode\":\"8004\"\n" +
        "            },\n" +
        "            \"adActive\":true,\n" +
        "            \"isQualityPartner\":false,\n" +
        "            \"isPremiumBranding\":true,\n" +
        "            \"profilePageUrlKeyword\":\"smg-swiss-marketplace-group-ag\"\n" +
        "         },\n" +
        "         \"listing\":{\n" +
        "            \"id\":\"104123262\",\n" +
        "            \"offerType\":\"BUY\",\n" +
        "            \"categories\":[\n" +
        "               \"HOUSE\",\n" +
        "               \"SINGLE_HOUSE\"\n" +
        "            ],\n" +
        "            \"prices\":{\n" +
        "               \"currency\":\"CHF\",\n" +
        "               \"buy\":{\n" +
        "                  \"area\":\"ALL\",\n" +
        "                  \"price\":9999999,\n" +
        "                  \"interval\":\"ONETIME\"\n" +
        "               }\n" +
        "            },\n" +
        "            \"address\":{\n" +
        "               \"country\":\"CH\",\n" +
        "               \"locality\":\"La Brévine\",\n" +
        "               \"postalCode\":\"2406\",\n" +
        "               \"region\":\"NE\",\n" +
        "               \"street\":\"Musterstrasse 999\",\n" +
        "               \"geoCoordinates\":{\n" +
        "                  \"latitude\":46.980351942307,\n" +
        "                  \"longitude\":6.606871481365\n" +
        "               }\n" +
        "            },\n" +
        "            \"characteristics\":{\n" +
        "               \"numberOfRooms\":9.5,\n" +
        "               \"livingSpace\":560,\n" +
        "               \"lotSize\":1691,\n" +
        "               \"totalFloorSpace\":996\n" +
        "            },\n" +
        "            \"localization\":{\n" +
        "               \"primary\":\"de\",\n" +
        "               \"de\":{\n" +
        "                  \"attachments\":[\n" +
        "                     {\n" +
        "                        \"type\":\"IMAGE\",\n" +
        "                        \"url\":\"https://media2.homegate.ch/listings/heia/104123262/image/6b53db714891bfe2321cc3a6d4af76e1.jpg\",\n" +
        "                        \"file\":\"201705241056461331496.jpg\"\n" +
        "                     },\n" +
        "                     {\n" +
        "                        \"type\":\"IMAGE\",\n" +
        "                        \"url\":\"https://media2.homegate.ch/listings/heia/104123262/image/328c41c0c0805299f5c28d680fbac4d9.jpg\",\n" +
        "                        \"file\":\"201705241056598207255.jpg\"\n" +
        "                     },\n" +
        "                     {\n" +
        "                        \"type\":\"IMAGE\",\n" +
        "                        \"url\":\"https://media2.homegate.ch/listings/heia/104123262/image/2333f298be7cc3609daaaf2e39e91bf9.jpg\",\n" +
        "                        \"file\":\"201705241056543197873.jpg\"\n" +
        "                     },\n" +
        "                     {\n" +
        "                        \"type\":\"IMAGE\",\n" +
        "                        \"url\":\"https://media2.homegate.ch/listings/heia/104123262/image/8944c80cb8afb8d5d579ca4faf7dbbb4.jpg\",\n" +
        "                        \"file\":\"201709182235035435737.jpg\"\n" +
        "                     },\n" +
        "                     {\n" +
        "                        \"type\":\"IMAGE\",\n" +
        "                        \"url\":\"https://media2.homegate.ch/listings/heia/104123262/image/bbb5b2fb8a1cf58ce690e0cfca23d266.jpg\",\n" +
        "                        \"file\":\"201705241056505004370.jpg\"\n" +
        "                     },\n" +
        "                     {\n" +
        "                        \"type\":\"DOCUMENT\",\n" +
        "                        \"url\":\"https://media2.homegate.ch/listings/heia/104123262/document/8d844358c73b10cc50c322591a1405c4.pdf\",\n" +
        "                        \"file\":\"202009141303411175201.pdf\"\n" +
        "                     },\n" +
        "                     {\n" +
        "                        \"type\":\"IMAGE\",\n" +
        "                        \"url\":\"https://media2.homegate.ch/listings/heia/104123262/image/9ed8163e3a9252f7eed28d5212bc1b11.jpg\",\n" +
        "                        \"file\":\"201709182234496788792.jpg\"\n" +
        "                     }\n" +
        "                  ],\n" +
        "                  \"text\":{\n" +
        "                     \"title\":\"Luxuriöses Einfamilienhaus mit Pool - Musterinserat\"\n" +
        "                  },\n" +
        "                  \"urls\":[\n" +
        "                     {\n" +
        "                        \"type\":\"VIRTUAL_TOUR\"\n" +
        "                     },\n" +
        "                     {\n" +
        "                        \"type\":\"YOUTUBE\"\n" +
        "                     }\n" +
        "                  ]\n" +
        "               }\n" +
        "            },\n" +
        "            \"lister\":{\n" +
        "               \"phone\":\"+41 44 711 86 67\",\n" +
        "               \"logoUrl\":\"https://media2.homegate.ch/t_customer_logo/logos/l_heia_v1.png\"\n" +
        "            }\n" +
        "         }\n" +
        "      }\n" +
        "  ],\n" +
        "\"maxFrom\": 0\n" +
        "}"