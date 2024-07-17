package com.abulnes16.compose_jetpack_glance.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.abulnes16.compose_jetpack_glance.data.database.models.WeatherDB
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather WHERE id =:id")
    fun getWeather(id: Int): Flow<WeatherDB>

    @Insert
    suspend fun insertWeather(weather: WeatherDB)

    @Update
    suspend fun updateWeather(weather: WeatherDB)
}