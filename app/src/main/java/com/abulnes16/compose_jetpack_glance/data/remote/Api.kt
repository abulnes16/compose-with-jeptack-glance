package com.abulnes16.compose_jetpack_glance.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Api {
    private val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl(OpenWeatherApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val weatherService = retrofitInstance.create(OpenWeatherApi::class.java)
}