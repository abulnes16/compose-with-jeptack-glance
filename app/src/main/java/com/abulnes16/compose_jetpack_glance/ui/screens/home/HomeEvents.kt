package com.abulnes16.compose_jetpack_glance.ui.screens.home

sealed class HomeEvents {
    data class OnChangeCity(val city: String): HomeEvents()
    object OnSearch: HomeEvents()

    data class OnFetchWeatherByLocation(val latitude: Double, val longitude: Double): HomeEvents()
}
