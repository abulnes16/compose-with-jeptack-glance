package com.abulnes16.compose_jetpack_glance.domain.models

import androidx.compose.ui.graphics.Color

data class WeatherType(
    val weatherIcon: Int,
    val weatherColor: Color
)
data class Weather(
    val weatherType: WeatherType,
    val temperature: Double,
    val city: String,
    val country: String,
    val humidity: Double,
    val wind: Double
)