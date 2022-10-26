package com.ilyusha.useful2.data.api.currencies

import com.ilyusha.useful2.data.api.models.currencies.CurrencyData
import retrofit2.Response
import retrofit2.http.GET

interface CurreniesApiService {

    @GET("?get=rates&pairs=USDRUB,EURRUB&key=d6d31827c7b276ac7f9f8d2666439121")
    suspend fun getCurrencies(): Response<CurrencyData>

}