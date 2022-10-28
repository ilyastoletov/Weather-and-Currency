package com.ilyusha.useful2.data.api.clients.geocoder

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GeocoderRetrofitObject {

    val geocoderApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://geocode-maps.yandex.ru/1.x/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GeocoderService::class.java)
    }

}