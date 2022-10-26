package com.ilyusha.useful2.data.api.models.weather

data class Info(
    val _h: Boolean,
    val def_pressure_mm: Number,
    val def_pressure_pa: Number,
    val f: Boolean,
    val geoid: Number,
    val lat: Number,
    val lon: Number,
    val n: Boolean,
    val nr: Boolean,
    val ns: Boolean,
    val nsr: Boolean,
    val p: Boolean,
    val slug: String,
    val tzinfo: Tzinfo,
    val url: String,
    val zoom: Number
)