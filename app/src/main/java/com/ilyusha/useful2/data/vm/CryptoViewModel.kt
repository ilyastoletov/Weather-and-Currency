package com.ilyusha.useful2.data.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilyusha.useful2.data.api.models.crypto.Crypto
import com.ilyusha.useful2.data.api.models.crypto.CryptoList
import com.ilyusha.useful2.data.repositories.CryptoRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class CryptoViewModel: ViewModel() {

    val repo = CryptoRepository()
    var curList: MutableLiveData<Response<Crypto>> = MutableLiveData()

    fun getCrypto() {
        viewModelScope.launch {
            curList.value = repo.getCrypto()
        }
    }
}