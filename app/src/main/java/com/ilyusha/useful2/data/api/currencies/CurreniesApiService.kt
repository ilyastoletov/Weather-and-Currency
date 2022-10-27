package com.ilyusha.useful2.data.api.currencies

import com.ilyusha.useful2.data.api.models.currencies.CurrencyData
import retrofit2.Response
import retrofit2.http.GET

interface CurreniesApiService {

    @GET("rates.json?iss.meta=off")
    suspend fun getCurrencies(): Response<CurrencyData>

}