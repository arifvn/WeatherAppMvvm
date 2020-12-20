package com.squareit.weatherapp.data.network

import com.squareit.weatherapp.data.network.client.WeatherService
import com.squareit.weatherapp.data.network.mapper.ApiMapper
import com.squareit.weatherapp.domain.model.Weather
import com.squareit.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val remoteApi: WeatherService,
    private val apiMapper: ApiMapper
) : WeatherRepository {

    override suspend fun getWeatherApiResponse(
        latitude: String,
        longitude: String
    ): Flow<Weather> = flow {
        remoteApi.getWeatherApiResponse(
            lat = latitude,
            lon = longitude,
        ).also {
            val weather = apiMapper.mapApiWeatherToDomain(it)
            emit(weather)
        }
    }

}