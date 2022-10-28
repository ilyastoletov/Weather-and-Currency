package com.ilyusha.useful2.data.api.clients.geocoder

import com.ilyusha.useful2.data.api.models.geocoder.GeocoderData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface GeocoderService {

    @GET("?")
    fun getCityName(@Query("geocode") geocode: String, @Query("apikey") apikey: String="f75f2782-6c2e-438d-bfb3-77be826cff57"): Call<GeocoderData>

}