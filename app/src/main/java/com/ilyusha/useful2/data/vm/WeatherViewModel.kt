package com.ilyusha.useful2.data.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilyusha.useful2.R
import com.ilyusha.useful2.data.api.models.weather.Condition
import com.ilyusha.useful2.data.repositories.WeatherRepository
import kotlinx.coroutines.launch

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
        println(condition)
        return when(condition) {
            "clear" -> Condition("Ясно", R.drawable.sunny)
            "partly-cloudy" -> Condition("Облачно с прояснениями", R.drawable.clear_cloudy)
            "cloudy", "overcast" -> Condition("Облачно", R.drawable.cloudy)
            "light-rain", "rain" -> Condition("Морось", R.drawable.small_rain_with_sun)
            "heavy-rain", "continuous-heavy-rain", "showers" -> Condition("Сильный дождь", R.drawable.showers)
            "light-snow", "snow" -> Condition("Снег", R.drawable.small_snow)
            "snow-showers" -> Condition("Снегопад", R.drawable.snow)
            "hail" -> Condition("Град", R.drawable.hail)
            "thunderstorm", "thunderstorm-with-rain", "thunderstorm-with-hail" -> Condition("Гроза", R.drawable.thunderstroms)
            else -> Condition("Ошибка", R.drawable.sunny)
        }
    }
}