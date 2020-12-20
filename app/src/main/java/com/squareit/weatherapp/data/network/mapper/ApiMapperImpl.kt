package com.squareit.weatherapp.data.network.mapper

import com.squareit.weatherapp.data.network.model.WeatherApiResponse
import com.squareit.weatherapp.domain.model.Weather
import com.squareit.weatherapp.util.extensions.convertTimeStampToStringDate
import com.squareit.weatherapp.util.extensions.convertTimeStampToStringTime

class ApiMapperImpl : ApiMapper {
    override fun mapApiWeatherToDomain(weatherApiResponse: WeatherApiResponse): Weather {
        return Weather(
            id = weatherApiResponse.current.weather[0].id,
            main = weatherApiResponse.current.weather[0].main,
            description = weatherApiResponse.current.weather[0].description,
            date = convertTimeStampToStringDate(weatherApiResponse.current.dt),
            sunrise = convertTimeStampToStringTime(weatherApiResponse.current.sunrise),
            sunset = convertTimeStampToStringTime(weatherApiResponse.current.sunset),
            temp = weatherApiResponse.current.temp.toString(),
            pressure = weatherApiResponse.current.pressure.toString(),
            humidity = weatherApiResponse.current.humidity.toString(),
            uvi = weatherApiResponse.current.uvi.toString(),
            windSpeed = weatherApiResponse.current.windSpeed.toString(),
            latitude = weatherApiResponse.latitude.toString(),
            longitude = weatherApiResponse.longitude.toString()
        )
    }
}