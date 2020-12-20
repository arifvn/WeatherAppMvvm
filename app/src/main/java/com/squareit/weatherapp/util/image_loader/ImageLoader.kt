package com.squareit.weatherapp.util.image_loader

import android.widget.ImageView

interface ImageLoader {
    fun load(image: String, target: ImageView)
}