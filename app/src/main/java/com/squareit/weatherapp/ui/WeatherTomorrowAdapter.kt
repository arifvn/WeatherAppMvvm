package com.squareit.weatherapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareit.weatherapp.databinding.ItemWeatherDaysBinding
import com.squareit.weatherapp.domain.model.Weather

class WeatherTomorrowAdapter : RecyclerView.Adapter<WeatherTomorrowAdapter.WeatherViewHolder>() {

    private val differ = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Weather>() {
        override fun areItemsTheSame(oldItem: Weather, newItem: Weather): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Weather, newItem: Weather): Boolean {
            return oldItem == newItem
        }
    })

    private fun submitList(list: MutableList<Weather>) {
        differ.submitList(list)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeatherViewHolder {
        val binding =
            ItemWeatherDaysBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherTomorrowAdapter.WeatherViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    inner class WeatherViewHolder(private val binding: ItemWeatherDaysBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(weather: Weather) {

        }
    }

    override fun getItemCount(): Int = differ.currentList.size
}