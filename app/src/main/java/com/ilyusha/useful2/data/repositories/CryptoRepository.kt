package com.ilyusha.useful2.data.repositories

import com.ilyusha.useful2.data.api.clients.crypto.RetrofitInstance
import com.ilyusha.useful2.data.api.models.crypto.Crypto
import retrofit2.Response

class CryptoRepository {

    suspend fun getCrypto(): Response<Crypto> {
        return RetrofitInstance.api.getCrypto()
    }
}