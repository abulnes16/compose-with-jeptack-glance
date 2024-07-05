package com.abulnes16.compose_jetpack_glance.domain.use_cases

import com.abulnes16.compose_jetpack_glance.data.mapper.toForecastList
import com.abulnes16.compose_jetpack_glance.data.remote.Api
import com.abulnes16.compose_jetpack_glance.domain.models.Forecast
import com.abulnes16.compose_jetpack_glance.utils.createWeatherUrl

class GetForecast(private val api: Api) {

    suspend operator fun invoke(latitude: Double, longitude: Double): Result<List<Forecast>> {
        val query = createWeatherUrl("onecall", "lat=${latitude}&lon=${longitude}&exclude=hourly,minutely")
        val response = api.weatherService.getForecast(query)
        return Result.success(response.toForecastList())
    }
}