package com.ilyusha.useful2.data.api.models.weather

data class Parts(
    val day: Day,
    val day_short: DayShort,
    val evening: Evening,
    val morning: Morning,
    val night: Night,
    val night_short: NightShort
)