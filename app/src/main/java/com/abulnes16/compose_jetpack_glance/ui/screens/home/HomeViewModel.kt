package com.abulnes16.compose_jetpack_glance.ui.screens.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abulnes16.compose_jetpack_glance.data.remote.dto.Coordinates
import com.abulnes16.compose_jetpack_glance.domain.models.FetchState
import com.abulnes16.compose_jetpack_glance.domain.use_cases.TempoUseCases
import kotlinx.coroutines.launch

class HomeViewModel(private val tempoUseCases: TempoUseCases) : ViewModel() {
    var state by mutableStateOf(HomeState())
        private set


    fun onEvent(event: HomeEvents) {
        when (event) {
            is HomeEvents.OnChangeCity -> {
                state = state.copy(cityName = event.city)
            }

            is HomeEvents.OnSearch -> {
                fetchWeather()
            }

            is HomeEvents.OnFetchWeatherByLocation -> {
                fetchWeather(
                    withCoordinates = true,
                    initialCoordinates = Coordinates(event.latitude, event.longitude)
                )
            }
        }
    }

    private fun fetchWeather(
        withCoordinates: Boolean = false,
        initialCoordinates: Coordinates = Coordinates(0.0, 0.0)
    ) {
        viewModelScope.launch {
            state = state.copy(fetchState = FetchState.LOADING)
            try {

                tempoUseCases.getWeather(state.cityName, withCoordinates, initialCoordinates)
                    .onSuccess { response ->
                        val (weather, coordinates) = response
                        val (lat, lon) = coordinates
                        fetchForecast(lat, lon)
                        state = state.copy(weather = weather, fetchState = FetchState.SUCCESS)
                    }.onFailure {
                        Log.e("[FETCH WEATHER]", it.message ?: "Error fetching weather")
                        state = state.copy(fetchState = FetchState.ERROR)
                    }

            } catch (e: Exception) {
                Log.e("[FETCH WEATHER]", e.message ?: "Error fetching weather")
                state = state.copy(fetchState = FetchState.ERROR)
            }
        }
    }

    private fun fetchForecast(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            try {
                tempoUseCases.getForecast(latitude, longitude).onSuccess {
                    state = state.copy(weeklyForecast = it, fetchState = FetchState.SUCCESS)
                }.onFailure {
                    Log.e("[FETCH FORECAST]", it.message ?: "Error fetching forecast")
                    state = state.copy(fetchState = FetchState.ERROR)
                }
            } catch (e: Exception) {
                Log.e("[FETCH FORECAST]", e.message ?: "Error fetching forecast")
                state = state.copy(fetchState = FetchState.ERROR)
            }
        }
    }
}