package com.ilyusha.useful2.data.api.models.geocoder

data class Country(
    val AddressLine: String,
    val AdministrativeArea: AdministrativeArea,
    val CountryName: String,
    val CountryNameCode: String
)