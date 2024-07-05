package com.abulnes16.compose_jetpack_glance.domain.use_cases

import com.abulnes16.compose_jetpack_glance.data.mapper.toWeather
import com.abulnes16.compose_jetpack_glance.data.remote.Api
import com.abulnes16.compose_jetpack_glance.data.remote.dto.Coordinates
import com.abulnes16.compose_jetpack_glance.domain.models.Weather
import com.abulnes16.compose_jetpack_glance.utils.createWeatherUrl

class GetWeather(private val api: Api) {
    suspend operator fun invoke(
        city: String,
        withCoordinates: Boolean = false,
        coordinates: Coordinates = Coordinates(0.0, 0.0)
    ): Result<Pair<Weather, Pair<Double, Double>>> {


      val query = if (!withCoordinates) {
             createWeatherUrl("weather", "q=${city}")
        } else {
             createWeatherUrl("weather", "lat=${coordinates.lat}&lon=${coordinates.lon}")
        }

        val response = api.weatherService.getWeather(query)
        return Result.success(
            Pair(
                response.toWeather(),
                Pair(response.coord.lat, response.coord.lon)
            )
        )
    }
}