package com.abulnes16.compose_jetpack_glance.domain.models


import androidx.compose.ui.graphics.Color
import com.abulnes16.compose_jetpack_glance.R
import com.abulnes16.compose_jetpack_glance.ui.theme.Primary

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

val mockWeatherType =  WeatherType(weatherIcon = R.drawable.ic_baseline_air, weatherColor = Primary)

val mockWeather = Weather(
    weatherType = mockWeatherType,
    temperature = 32.0,
    city = "Tegucigalpa",
    country = "Honduras",
    humidity = 10.0,
    wind = 2.5
)