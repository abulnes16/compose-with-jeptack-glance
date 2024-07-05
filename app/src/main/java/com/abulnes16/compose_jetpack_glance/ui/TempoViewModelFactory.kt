package com.abulnes16.compose_jetpack_glance.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.abulnes16.compose_jetpack_glance.data.remote.Api
import com.abulnes16.compose_jetpack_glance.domain.use_cases.GetForecast
import com.abulnes16.compose_jetpack_glance.domain.use_cases.GetWeather
import com.abulnes16.compose_jetpack_glance.domain.use_cases.TempoUseCases
import com.abulnes16.compose_jetpack_glance.ui.screens.home.HomeViewModel

val TempoViewModelFactory = object : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {

        return with(modelClass) {
            when {
                isAssignableFrom(HomeViewModel::class.java) -> {
                    val tempoUseCases = TempoUseCases(
                        getWeather = GetWeather(api = Api),
                        getForecast = GetForecast(api = Api)
                    )
                    HomeViewModel(tempoUseCases)
                }
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
    }
}