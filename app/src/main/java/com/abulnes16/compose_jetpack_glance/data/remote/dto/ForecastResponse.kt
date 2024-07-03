package com.abulnes16.compose_jetpack_glance.data.remote.dto

import com.squareup.moshi.Json


data class DailyForecastTemperature(
    val day: Double,
    val min: Double,
    val max: Double,
    val night: Double,
    val eve: Double,
    val morn: Double,
)

data class DailyForecast(
    val dt: Long,
    val sunrise: Long,
    val sunset: Long,
    val moonrise: Long,
    val moonset: Long,
    @field:Json(name = "moon_phase")
    val moonPhase: Double,
    val temp: DailyForecastTemperature,
    val pressure: Int,
    val humidity: Int,
    @field:Json(name = "wind_speed")
    val windSpeed: Double,
    val weather: List<WeatherInfo>
)

data class ForecastResponse(
    val lat: Double,
    val lon: Double,
    val timezone: String,
    @field:Json(name = "timezone_offset")
    val timezoneOffset: String,
    val daily: List<DailyForecast>,
)
