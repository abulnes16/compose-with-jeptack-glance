package com.abulnes16.compose_jetpack_glance

import android.app.Application
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class TempoApplication: Application() {
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
    }

    companion object {
        @get:Synchronized
        lateinit var instance: TempoApplication
        private set
    }

}