package com.abulnes16.compose_jetpack_glance

import android.app.Application
import com.abulnes16.compose_jetpack_glance.data.database.WeatherDatabase
import com.abulnes16.compose_jetpack_glance.data.repository.OfflineWeatherRepository
import com.abulnes16.compose_jetpack_glance.data.repository.WeatherRepository
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class TempoApplication: Application() {
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
        private set

    lateinit var weatherRepository: WeatherRepository
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        weatherRepository = OfflineWeatherRepository(WeatherDatabase.getDatabase(this).weatherDao())
    }

    companion object {
        @get:Synchronized
        lateinit var instance: TempoApplication
        private set

    }

}