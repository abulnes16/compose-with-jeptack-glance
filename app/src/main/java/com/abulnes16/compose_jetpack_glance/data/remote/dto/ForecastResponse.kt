package com.abulnes16.compose_jetpack_glance.data.remote.dto


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
    val moon_phase: Double,
    val temp: DailyForecastTemperature,
    val pressure: Int,
    val humidity: Int,
    val wind_speed: Double,
    val weather: List<WeatherInfo>
)

data class ForecastResponse(
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: String,
    val daily: List<DailyForecast>,
)
