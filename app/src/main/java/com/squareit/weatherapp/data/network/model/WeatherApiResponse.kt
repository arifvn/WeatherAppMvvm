package com.squareit.weatherapp.data.network.model

import com.google.gson.annotations.SerializedName

class WeatherApiResponse(
    @SerializedName("lat") val latitude: Double,
    @SerializedName("lon") val longitude: Double,
    @SerializedName("timezone") val timezone: String,
    @SerializedName("timezone_offset") val timezoneOffset: Long,
    @SerializedName("current") val current: Current,
)

data class Current(
    @SerializedName("dt") val dt: Long,
    @SerializedName("sunrise") val sunrise: Long,
    @SerializedName("sunset") val sunset: Long,
    @SerializedName("temp") val temp: Double,
    @SerializedName("feels_like") val degree: Double,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("dew_point") val dew: Double,
    @SerializedName("uvi") val uvi: Double,
    @SerializedName("clouds") val clouds: Int,
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("wind_speed") val windSpeed: Double,
    @SerializedName("wind_deg") val windDegree: Int,
    @SerializedName("weather") val weather: List<Weather>,

    )

data class Weather(
    @SerializedName("id") val id: Int,
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String
)