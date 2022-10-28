package com.ilyusha.useful2.data.repositories

import com.ilyusha.useful2.data.api.clients.currencies.CurrenciesRetrofitInstance
import com.ilyusha.useful2.data.api.clients.geocoder.GeocoderRetrofitObject
import com.ilyusha.useful2.data.api.models.currencies.CurrencyData
import com.ilyusha.useful2.data.api.models.weather.Weather
import com.ilyusha.useful2.data.api.clients.weather.WeatherRetrofitInstance
import com.ilyusha.useful2.data.api.models.geocoder.GeocoderData
import retrofit2.Call
import retrofit2.Response

class WeatherRepository {

    suspend fun getWeatherByCityName(lat: Double, lon: Double): Response<Weather> {
        return WeatherRetrofitInstance.weatherApi.getWeather(lat.toString(), lon.toString())
    }

    suspend fun getCurrencies(): Response<CurrencyData> {
        return CurrenciesRetrofitInstance.curreniesApi.getCurrencies()
    }

    fun getCityName(city: String): Call<GeocoderData> {
        return GeocoderRetrofitObject.geocoderApi.getCityName(city)
    }

}