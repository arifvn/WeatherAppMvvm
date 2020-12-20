package com.squareit.weatherapp.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.squareit.viewbinder.viewBinder
import com.squareit.weatherapp.data.network.Resource
import com.squareit.weatherapp.databinding.ActivityWeatherBinding
import com.squareit.weatherapp.util.extensions.lok
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class WeatherActivity : AppCompatActivity() {

    private val viewModel: WeatherViewModel by viewModels()
    private val binding: ActivityWeatherBinding by viewBinder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.bgTop.visibility = View.VISIBLE

        val lat = "-7.524270"
        val lon = "110.004341"

        viewModel.getWeatherApiResponse(lat, lon)

        viewModel.result.observe(this) {
            when (it.status) {
                Resource.Status.LOADING -> lok(it.status)
                Resource.Status.ERROR -> lok(it.message!!)
                Resource.Status.SUCCESS -> lok(it.data!!)
            }
        }
    }
}
