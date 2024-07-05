package com.abulnes16.compose_jetpack_glance.data.remote.dto


data class Coordinates(
    val lat: Double,
    val lon: Double
)

data class Wind(
    val speed: Double,
    val deg: Int
)

data class WeatherInfo(
    val id: Double,
    val main: String,
    val description: String,
    val icon: String
)



data class Temperature(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Double,
    val humidity: Double
)

data class Cloud(
    val all: Int
)

data class SystemInfo(
    val type: Int,
    val id: Int,
    val message: Double,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
)


data class WeatherResponse(
    val coord: Coordinates,
    val weather: List<WeatherInfo>,
    val main: Temperature,
    val base: String,
    val visibility: Double,
    val clouds: Cloud,
    val wind: Wind,
    val dt: Long,
    val sys: SystemInfo,
    val timezone: Int,
    val id: Long,
    val name: String,
    val cod: Int
)