package com.example.weatherapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.RetrofitInstance
import com.example.weatherapp.model.WindDataModel
import com.example.weatherapp.model.temperature.TempDataModel
import com.example.weatherapp.pressure.PressureModel
import com.example.weatherapp.sunrise.SunriseModel
import com.example.weatherapp.sunset.SunsetModel
import com.example.weatherapp.uv.UVModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class MainActivityViewModel():ViewModel() {

    private val _wind = MutableSharedFlow<WindDataModel?>()
    val wind = _wind.asSharedFlow()

    private val _pressure = MutableSharedFlow<PressureModel?>()
    val pressure= _pressure.asSharedFlow()

    private val _temp = MutableSharedFlow<TempDataModel?>()
    val temp = _temp.asSharedFlow()


    fun getWind() {
        viewModelScope.launch(Dispatchers.IO) {
           val res = RetrofitInstance.api.getWindWeatherData()
            if (res.isSuccessful) {
                _wind.emit(res.body())
            }
        }
    }

    fun getPressure() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = RetrofitInstance.api.getPressureWeatherData()
            if (res.isSuccessful) {
                _pressure.emit(res.body())
            }
        }
    }

    fun getTemp() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = RetrofitInstance.api.getTempWeatherData()
            if (res.isSuccessful) {
                _temp.emit(res.body())
            }
        }
    }

    private val _sunrise = MutableSharedFlow<SunriseModel?>()
    val sunrise = _sunrise.asSharedFlow()

    fun getSunrise() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = RetrofitInstance.api.getSunriseWeatherData()
            if (res.isSuccessful) {
                _sunrise.emit(res.body())
            }
        }
    }

    private val _sunset = MutableSharedFlow<SunsetModel?>()
    val sunset= _sunset.asSharedFlow()
    fun getSunset() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = RetrofitInstance.api.getSunsetWeatherData()
            if (res.isSuccessful) {
                _sunset.emit(res.body())
            }
        }
    }

    private val _uv = MutableSharedFlow<UVModel?>()
    val uv= _uv.asSharedFlow()

    fun getUV() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = RetrofitInstance.api.getUVWeatherData()
            if (res.isSuccessful) {
                _uv.emit(res.body())
            }
        }
    }
}