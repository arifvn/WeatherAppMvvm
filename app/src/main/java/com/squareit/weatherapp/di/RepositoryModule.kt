package com.squareit.weatherapp.di

import com.squareit.weatherapp.data.network.WeatherRepositoryImpl
import com.squareit.weatherapp.data.network.client.WeatherService
import com.squareit.weatherapp.data.network.mapper.ApiMapper
import com.squareit.weatherapp.data.network.mapper.ApiMapperImpl
import com.squareit.weatherapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Provides
    fun provideApiMapperImpl(): ApiMapper = ApiMapperImpl()

    @Provides
    fun provideWeatherRepositoryImpl(
        remoteApi: WeatherService,
        apiMapper: ApiMapper
    ): WeatherRepository =
        WeatherRepositoryImpl(remoteApi, apiMapper)
}