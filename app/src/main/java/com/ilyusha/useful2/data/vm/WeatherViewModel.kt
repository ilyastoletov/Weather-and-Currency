package com.ilyusha.useful2.data.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilyusha.useful2.R
import com.ilyusha.useful2.data.api.models.weather.Condition
import com.ilyusha.useful2.data.api.models.weather.Weather
import com.ilyusha.useful2.data.repositories.WeatherRepository
import com.ilyusha.useful2.recyclers.weather.WeatherData
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {

    val repo = WeatherRepository()

    var weatherResponse: MutableLiveData<Weather> = MutableLiveData()
    var weatherHoursPrediction: MutableLiveData<ArrayList<WeatherData>> = MutableLiveData()

    var _dollarCourse: MutableLiveData<String> = MutableLiveData()
    var _euroCourse: MutableLiveData<String> = MutableLiveData()

    var _weatherDegrees: MutableLiveData<String> = MutableLiveData()
    var _weatherCondition: MutableLiveData<Condition> = MutableLiveData()

    var weatherDegrees: LiveData<String> = _weatherDegrees
    var weatherCondition: LiveData<Condition> = _weatherCondition
    var dollarCourse: LiveData<String> = _dollarCourse
    var euroCourse: LiveData<String> = _euroCourse

    fun getWeatherByCity(lat: Double, lon: Double) {
        viewModelScope.launch {
            val responseBody = repo.getWeatherByCityName(lat, lon).body()!!
            weatherResponse.value = responseBody
            weatherHoursPrediction.value = getHoursPrediction()
            _weatherDegrees.value = responseBody.fact.temp.toString() + "°C"
            _weatherCondition.value = getCondition(responseBody.fact.condition)
        }
    }

    fun getCurrenciesCourse() {
        viewModelScope.launch {
            val response = repo.getCurrencies().body()!!
            _dollarCourse.value = response.wap_rates.data[0][4].toString().dropLast(2) + " ₽"
            _euroCourse.value = response.wap_rates.data[1][4].toString().dropLast(2) + " ₽"
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
            "wet-snow" -> Condition("Снег с дождём", R.drawable.snow_with_rain)
            "snow-showers" -> Condition("Снегопад", R.drawable.snow)
            "hail" -> Condition("Град", R.drawable.hail)
            "thunderstorm", "thunderstorm-with-rain", "thunderstorm-with-hail" -> Condition("Гроза", R.drawable.thunderstroms)
            else -> Condition("Ошибка", R.drawable.sunny)
        }
    }

    fun getHoursPrediction(): ArrayList<WeatherData> {
        var hourPrediction: ArrayList<WeatherData> = arrayListOf()
            for (forecast in weatherResponse.value!!.forecasts) {
                for (hour in forecast.hours) {
                    hourPrediction.add(
                        WeatherData("${hour.hour}:00", getCondition(hour.condition).conditionImageId, "${hour.temp}°C"))
                }
            }
        hourPrediction.add(WeatherData("29:00", R.drawable.sunny, "br"))
        return hourPrediction
    }

    fun getCityWeather(city: String) {
        println(repo.getCityName(city).request().body())
    }

}