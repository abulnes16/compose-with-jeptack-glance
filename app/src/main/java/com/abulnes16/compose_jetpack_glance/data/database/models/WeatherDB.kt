package com.abulnes16.compose_jetpack_glance.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class WeatherDB(
    @PrimaryKey
    val id: Int = 0,
    val temperature: Double,
    val city: String,
    val country: String,
    val humidity: Double,
    val wind: Double,
    @ColumnInfo(name ="weather_icon")
    val weatherIcon: Int,
)