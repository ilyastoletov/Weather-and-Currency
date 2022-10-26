package com.ilyusha.useful2.data.api.models.weather

data class Tzinfo(
    val abbr: String,
    val dst: Boolean,
    val name: String,
    val offset: Number
)