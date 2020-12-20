package com.squareit.weatherapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareit.weatherapp.data.network.WeatherRepositoryImpl
import com.squareit.weatherapp.data.network.api.Constant
import com.squareit.weatherapp.data.network.client.WeatherService
import com.squareit.weatherapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        // Add Default Query
        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor(Interceptor { chain ->

            val original = chain.request()
            val originalHttpUrl = original.url

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("appid", Constant.API_KEY)
                .addQueryParameter("units", "metric")
                .addQueryParameter("exclude", "minutely,hourly,daily")
                .build()

            val requestBuilder = original.newBuilder()
                .url(url)

            val request = requestBuilder.build()
            chain.proceed(request)
        })

        // Add Log
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        return httpClient.addInterceptor(logging).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit =
        Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Constant.BASE_URL)
            .build()

    @Singleton
    @Provides
    fun provideWeatherService(retrofit: Retrofit): WeatherService =
        retrofit.create(WeatherService::class.java)
}