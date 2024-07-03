package com.abulnes16.compose_jetpack_glance.data.mapper

import com.abulnes16.compose_jetpack_glance.data.remote.dto.DailyForecast
import com.abulnes16.compose_jetpack_glance.data.remote.dto.ForecastResponse
import com.abulnes16.compose_jetpack_glance.domain.models.Forecast
import com.abulnes16.compose_jetpack_glance.utils.convertTemperature
import com.abulnes16.compose_jetpack_glance.utils.getWeatherType
import com.abulnes16.compose_jetpack_glance.utils.getWeekOfDay

fun DailyForecast.toForecast(): Forecast {
    val weatherType = getWeatherType(this.weather[0].main)
    val day = getWeekOfDay(this.dt)
    val temperature = convertTemperature(this.temp.day)
    return Forecast(
        weatherType = weatherType,
        day = day,
        temperature = temperature.toString()
    )
}

fun ForecastResponse.toForecastList(): List<Forecast> {
    return this.daily.map { it.toForecast() }
}