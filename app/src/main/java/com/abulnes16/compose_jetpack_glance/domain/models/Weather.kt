package com.abulnes16.compose_jetpack_glance.domain.models


import androidx.compose.ui.graphics.Color
import com.abulnes16.compose_jetpack_glance.R
import com.abulnes16.compose_jetpack_glance.data.database.models.WeatherDB
import com.abulnes16.compose_jetpack_glance.ui.theme.Primary

data class WeatherType(
    val weatherIcon: Int,
    val weatherColor: Color,
    val weatherName: String,
)
data class Weather(
    val weatherType: WeatherType,
    val temperature: Double,
    val city: String,
    val country: String,
    val humidity: Double,
    val wind: Double
)

val mockWeatherType =  WeatherType(weatherIcon = R.drawable.ic_baseline_air, weatherColor = Primary, weatherName = "Windy")

val mockWeather = Weather(
    weatherType = mockWeatherType,
    temperature = 32.0,
    city = "Tegucigalpa",
    country = "Honduras",
    humidity = 10.0,
    wind = 2.5
)

fun Weather.toWeatherDB(): WeatherDB {
    return WeatherDB(
        id = 0,
        city = city,
        country = country,
        humidity = humidity,
        temperature = temperature,
        wind = wind,
        weatherIcon = weatherType.weatherIcon
    )
}