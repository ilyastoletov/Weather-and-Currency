package com.ilyusha.useful2.data.api.clients.crypto

import com.ilyusha.useful2.data.api.models.crypto.Crypto
import com.ilyusha.useful2.data.api.models.crypto.CryptoList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("simple/price?ids=bitcoin,solana,ethereum,bnb,ripple,binancecoin,litecoin&vs_currencies=usd")
    suspend fun getCrypto(): Response<Crypto>
}