package com.ilyusha.useful2.data.api.models.weather

data class Weather(
    val fact: Fact,
    val forecasts: List<Forecast>,
    val geo_object: GeoObject,
    val info: Info,
    val now: Number,
    val now_dt: String,
    val yesterday: Yesterday
)