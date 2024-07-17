package com.abulnes16.compose_jetpack_glance.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.abulnes16.compose_jetpack_glance.data.database.dao.WeatherDao
import com.abulnes16.compose_jetpack_glance.data.database.models.WeatherDB

@Database(entities = [WeatherDB::class], version = 1, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase(){
    abstract fun weatherDao(): WeatherDao

    companion object {
        @Volatile
        private var Instance: WeatherDatabase? = null

        fun getDatabase(context: Context): WeatherDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, WeatherDatabase::class.java, "weather_database")
                    .fallbackToDestructiveMigration().build().also { Instance = it }
            }
        }
    }

}