package com.abulnes16.compose_jetpack_glance.domain.use_cases

import com.abulnes16.compose_jetpack_glance.data.mapper.toWeather
import com.abulnes16.compose_jetpack_glance.data.remote.Api
import com.abulnes16.compose_jetpack_glance.domain.models.Weather
import com.abulnes16.compose_jetpack_glance.utils.createWeatherUrl

class GetWeather(private val api: Api) {
    suspend operator fun invoke(city: String): Result<Pair<Weather, Pair<Double, Double>>>{
        val query = createWeatherUrl("weather", "q=${city}")
        val response = api.weatherService.getWeather(query)
        return Result.success(Pair(response.toWeather(), Pair(response.coord.lat, response.coord.lon)))
    }
}