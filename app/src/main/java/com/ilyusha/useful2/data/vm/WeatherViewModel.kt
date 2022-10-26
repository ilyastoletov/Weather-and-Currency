package com.ilyusha.useful2.data.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilyusha.useful2.data.api.models.crypto.Crypto
import com.ilyusha.useful2.data.api.models.weather.Condition
import com.ilyusha.useful2.data.api.models.weather.Weather
import com.ilyusha.useful2.data.repositories.WeatherRepository
import com.ilyusha.useful2.data.utils.Condition
import com.ilyusha.useful2.data.utils.ConditionState
import kotlinx.coroutines.launch
import retrofit2.Response

class WeatherViewModel: ViewModel() {

    val repo = WeatherRepository()

    var _weatherDegrees: MutableLiveData<String> = MutableLiveData()
    var _weatherCondition: MutableLiveData<Condition> = MutableLiveData()

    var weatherDegrees: LiveData<String> = _weatherDegrees
    var weatherCondition: LiveData<Condition> = _weatherCondition

    fun getWeatherTogliatti() {
        viewModelScope.launch {
            val responseBody = repo.getWeatherTogliatti().body()!!
            _weatherDegrees.value = responseBody.fact.temp.toString() + "°C"
            _weatherCondition.value = getCondition(responseBody.fact.condition)
        }
    }

    fun getCondition(condition: String): Condition {
        return when(condition) {
            "rain" -> Condition("Дождь")
        }
    }
}