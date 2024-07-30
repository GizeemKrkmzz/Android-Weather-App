package com.example.weatherapp
import com.example.weatherapp.model.WindDataModel
import com.example.weatherapp.model.temperature.TempDataModel
import com.example.weatherapp.pressure.PressureModel
import com.example.weatherapp.sunrise.SunriseModel
import com.example.weatherapp.sunset.SunsetModel
import com.example.weatherapp.uv.UVModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.HeaderMap

interface SimpleApi {
    @GET("/2024-07-30T00:00:00Z/wind_speed_10m:ms/52.520551,13.461804/json")
    suspend fun getWindWeatherData(): Response<WindDataModel>

    @GET("/2024-07-30T00:00:00Z/t_2m:C/52.520551,13.461804/json")
    suspend fun getTempWeatherData(): Response<TempDataModel>

    @GET("/2024-07-30T00:00:00Z/sunrise:sql/52.520551,13.461804/json")
    suspend fun getSunriseWeatherData():Response<SunriseModel>

    @GET("/2024-07-30T00:00:00Z/sunset:sql/52.520551,13.461804/json")
    suspend fun getSunsetWeatherData(): Response<SunsetModel>

    @GET("/2024-07-30T00:00:00Z/msl_pressure:hPa/52.520551,13.461804/json")
    suspend fun getPressureWeatherData(): Response<PressureModel>

    @GET("/2024-07-30T00:00:00Z/uv:idx/52.520551,13.461804/json")
    suspend fun getUVWeatherData(): Response<UVModel>


}
data class WindDataModel (
    val title:String,
    val body:String,
)

