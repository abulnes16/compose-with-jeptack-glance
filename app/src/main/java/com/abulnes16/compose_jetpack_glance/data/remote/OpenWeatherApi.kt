package com.abulnes16.compose_jetpack_glance.data.remote

import com.abulnes16.compose_jetpack_glance.data.remote.dto.ForecastResponse
import com.abulnes16.compose_jetpack_glance.data.remote.dto.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface OpenWeatherApi {

    @GET
    suspend fun getWeather(@Url url: String): WeatherResponse

    @GET
    suspend fun getForecast(@Url url: String): ForecastResponse
    companion object {
        val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    }
}