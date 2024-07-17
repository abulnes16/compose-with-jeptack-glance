package com.abulnes16.compose_jetpack_glance.data.mapper

import com.abulnes16.compose_jetpack_glance.data.database.models.WeatherDB
import com.abulnes16.compose_jetpack_glance.data.remote.dto.WeatherResponse
import com.abulnes16.compose_jetpack_glance.domain.models.Weather
import com.abulnes16.compose_jetpack_glance.utils.convertTemperature
import com.abulnes16.compose_jetpack_glance.utils.getWeatherType

fun WeatherResponse.toWeather(): Weather {
    val temperature = convertTemperature(this.main.temp)
    val name = this.name
    val country = this.sys.country
    val humidity = this.main.humidity
    val wind = this.wind.speed
    val weatherType = getWeatherType(this.weather[0].main)
    return Weather(
        city = name,
        country = country,
        humidity = humidity,
        temperature = temperature,
        wind = wind,
        weatherType = weatherType
    )
}

