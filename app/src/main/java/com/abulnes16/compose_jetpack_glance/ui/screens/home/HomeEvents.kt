package com.abulnes16.compose_jetpack_glance.ui.screens.home

sealed class HomeEvents {
    data class OnChangeCity(val city: String): HomeEvents()
    object OnSearch: HomeEvents()
}
