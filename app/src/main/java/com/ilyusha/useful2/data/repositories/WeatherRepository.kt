package com.ilyusha.useful2.data.repositories

import com.ilyusha.useful2.data.api.currencies.CurrenciesRetrofitInstance
import com.ilyusha.useful2.data.api.models.currencies.CurrencyData
import com.ilyusha.useful2.data.api.models.weather.Weather
import com.ilyusha.useful2.data.api.weather.WeatherRetrofitInstance
import retrofit2.Response

class WeatherRepository {

    suspend fun getWeatherTogliatti(): Response<Weather> {
        return WeatherRetrofitInstance.weatherApi.getWeatherTogliatti()
    }

    suspend fun getCurrencies(): Response<CurrencyData> {
        println(CurrenciesRetrofitInstance.curreniesApi.getCurrencies().body())
        return CurrenciesRetrofitInstance.curreniesApi.getCurrencies()
    }

}