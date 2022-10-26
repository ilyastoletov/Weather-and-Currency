package com.ilyusha.useful2.data.api.weather

import com.ilyusha.useful2.data.api.models.weather.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface WeatherApiService {

    @Headers("X-Yandex-API-Key: 45046400-df74-4ceb-9fbb-fad191378423")
    @GET("forecast?lat=53.5303&lon=49.3461&limit=1")
    suspend fun getWeatherTogliatti(): Response<Weather>

}