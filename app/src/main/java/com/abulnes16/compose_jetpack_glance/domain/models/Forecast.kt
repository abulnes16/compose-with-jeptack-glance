package com.abulnes16.compose_jetpack_glance.domain.models

data class Forecast(
    val weatherType: WeatherType,
    val day: String,
    val temperature: String
)
