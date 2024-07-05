package com.abulnes16.compose_jetpack_glance.domain.models

data class Forecast(
    val weatherType: WeatherType,
    val day: String,
    val temperature: String
)


val mockForecastList = listOf<Forecast>(
    Forecast(
        weatherType = mockWeatherType,
        day = "Lu",
        temperature = "29",
    ),
    Forecast(
        weatherType = mockWeatherType,
        day = "Ma",
        temperature = "29",
    ),
    Forecast(
        weatherType = mockWeatherType,
        day = "Mi",
        temperature = "29",
    ),

)