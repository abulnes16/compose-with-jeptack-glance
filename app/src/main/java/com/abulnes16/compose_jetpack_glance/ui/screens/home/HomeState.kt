package com.abulnes16.compose_jetpack_glance.ui.screens.home

import com.abulnes16.compose_jetpack_glance.data.database.models.WeatherDB
import com.abulnes16.compose_jetpack_glance.domain.models.FetchState
import com.abulnes16.compose_jetpack_glance.domain.models.Forecast
import com.abulnes16.compose_jetpack_glance.domain.models.Weather

data class HomeState(
    val cityName: String = "",
    val weather: Weather? = null,
    val weeklyForecast: List<Forecast> = listOf(),
    val fetchState: FetchState = FetchState.LOADING,
    val locationError: Boolean = false,
    val permissionDenied: Boolean = false,
    val weatherInDatabase: WeatherDB? = null,
)
