package com.ilyusha.useful2.data.api.models.geocoder

data class GeocoderResponseMetaData(
    val boundedBy: BoundedBy,
    val found: String,
    val request: String,
    val results: String
)