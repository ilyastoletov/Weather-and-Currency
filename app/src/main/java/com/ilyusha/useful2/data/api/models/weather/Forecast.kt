package com.ilyusha.useful2.data.api.models.weather

data class Forecast(
    val biomet: Biomet,
    val date: String,
    val date_ts: Number,
    val hours: List<Hour>,
    val moon_code: Number,
    val moon_text: String,
    val parts: Parts,
    val rise_begin: String,
    val set_end: String,
    val sunrise: String,
    val sunset: String,
    val week: Number
)