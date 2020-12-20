package com.squareit.weatherapp.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.squareit.weatherapp.data.network.Resource
import com.squareit.weatherapp.domain.model.Weather
import com.squareit.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class WeatherViewModel @ViewModelInject constructor(
    private val repository: WeatherRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _result = MutableLiveData<Resource<Weather>>()
    val result: LiveData<Resource<Weather>> = _result

    fun getWeatherApiResponse(latitude: String, longitude: String) {
        viewModelScope.launch {
            repository.getWeatherApiResponse(latitude, longitude)
                .onStart {
                    _result.postValue(Resource.loading(null))
                }
                .catch {
                    _result.postValue(Resource.error(null, "Something went wrong"))
                }
                .collect {
                    _result.postValue(Resource.success(it))
                }
        }
    }
}