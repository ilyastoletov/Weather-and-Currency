package com.ilyusha.useful2.data.api.models.geocoder

data class Address(
    val Components: List<Component>,
    val country_code: String,
    val formatted: String
)