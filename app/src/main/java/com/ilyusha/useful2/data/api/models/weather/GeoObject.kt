package com.ilyusha.useful2.data.api.models.weather

data class GeoObject(
    val country: Country,
    val district: District,
    val locality: Locality,
    val province: Province
)