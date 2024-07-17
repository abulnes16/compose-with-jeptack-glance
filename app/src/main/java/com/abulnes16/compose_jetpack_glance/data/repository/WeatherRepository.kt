package com.abulnes16.compose_jetpack_glance.data.repository

import com.abulnes16.compose_jetpack_glance.data.database.dao.WeatherDao
import com.abulnes16.compose_jetpack_glance.data.database.models.WeatherDB
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    fun getWeather(id: Int): Flow<WeatherDB?>

    suspend fun insertWeather(weatherDB: WeatherDB)

    suspend fun updateWeather(weatherDB: WeatherDB)
}


class OfflineWeatherRepository(private val weatherDao: WeatherDao) : WeatherRepository {
    override fun getWeather(id: Int): Flow<WeatherDB?> = weatherDao.getWeather(id)

    override suspend fun insertWeather(weatherDB: WeatherDB) = weatherDao.insertWeather(weatherDB)

    override suspend fun updateWeather(weatherDB: WeatherDB) = weatherDao.updateWeather(weatherDB)

}