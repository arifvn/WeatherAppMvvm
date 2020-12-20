package com.squareit.weatherapp.data.network.client

import com.squareit.weatherapp.data.network.model.WeatherApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("onecall")
    suspend fun getWeatherApiResponse(
        @Query("lat") lat: String,
        @Query("lon") lon: String
    ): WeatherApiResponse
}