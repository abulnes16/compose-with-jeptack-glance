package com.abulnes16.compose_jetpack_glance.utils

import com.abulnes16.compose_jetpack_glance.BuildConfig
import com.abulnes16.compose_jetpack_glance.R
import com.abulnes16.compose_jetpack_glance.domain.models.WeatherType
import com.abulnes16.compose_jetpack_glance.domain.models.WeatherTypes
import com.abulnes16.compose_jetpack_glance.ui.theme.Alternative
import com.abulnes16.compose_jetpack_glance.ui.theme.Gray
import com.abulnes16.compose_jetpack_glance.ui.theme.Primary
import com.abulnes16.compose_jetpack_glance.ui.theme.Secondary
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.floor


fun convertTemperature(temp: Double): Double {
    return floor(temp - 273.15)
}

fun getWeatherType(weatherType: String): WeatherType {

    val weatherIcon = when (weatherType) {
        WeatherTypes.Sun.weatherName -> R.drawable.ic_baseline_wb_sunny
        WeatherTypes.Clouds.weatherName -> R.drawable.ic_baseline_wb_cloudy
        WeatherTypes.Drizzle.weatherName -> R.drawable.ic_baseline_waves
        WeatherTypes.Rain.weatherName -> R.drawable.ic_baseline_water
        WeatherTypes.Snow.weatherName -> R.drawable.ic_baseline_snow
        WeatherTypes.Thunderstorm.weatherName -> R.drawable.ic_baseline_wb_cloudy
        else -> R.drawable.ic_baseline_air
    }



    val weatherColor = when (weatherType) {
        WeatherTypes.Sun.weatherName -> Secondary

        WeatherTypes.Thunderstorm.weatherName,
        WeatherTypes.Clouds.weatherName -> Gray

        WeatherTypes.Snow.weatherName,
        WeatherTypes.Rain.weatherName,
        WeatherTypes.Drizzle.weatherName -> Alternative

        else -> Primary

    }

    return WeatherType(weatherIcon = weatherIcon, weatherColor = weatherColor, weatherName = weatherType)
}

fun getWeekOfDay(date: Long): String {
    val dateObj = Date(date * 1000)
    return SimpleDateFormat("EEEE", Locale.ENGLISH).format(dateObj)
        .replaceFirstChar { it.uppercase() }
}

fun createWeatherUrl(resource: String, query: String): String{
    return "${resource}?${query}&appId=${BuildConfig.API_KEY}"
}