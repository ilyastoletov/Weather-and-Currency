package com.ilyusha.useful2.data.api.currencies

import com.ilyusha.useful2.data.api.weather.WeatherApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CurrenciesRetrofitInstance {

    val curreniesApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://currate.ru/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurreniesApiService::class.java)
    }

}