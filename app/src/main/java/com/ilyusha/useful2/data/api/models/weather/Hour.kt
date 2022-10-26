package com.ilyusha.useful2.data.api.models.weather

data class Hour(
    val cloudness: Number,
    val condition: String,
    val feels_like: Number,
    val hour: String,
    val hour_ts: Number,
    val humidity: Number,
    val icon: String,
    val is_thunder: Boolean,
    val prec_mm: Number,
    val prec_period: Number,
    val prec_prob: Number,
    val prec_strength: Number,
    val prec_type: Number,
    val pressure_mm: Number,
    val pressure_pa: Number,
    val soil_moisture: Number,
    val soil_temp: Number,
    val temp: Number,
    val temp_water: Number,
    val uv_index: Number,
    val wind_dir: String,
    val wind_gust: Number,
    val wind_speed: Number
)