package com.ilyusha.useful2.data.api.clients.weather

import com.ilyusha.useful2.data.api.models.geocoder.GeocoderData
import com.ilyusha.useful2.data.api.models.weather.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface WeatherApiService {

    @Headers("X-Yandex-API-Key: 45046400-df74-4ceb-9fbb-fad191378423")
    @GET("forecast?")
    suspend fun getWeather(@Query("lat") lat: String, @Query("lon") lon: String, @Query("limit") lim: Int=1): Response<Weather>

}