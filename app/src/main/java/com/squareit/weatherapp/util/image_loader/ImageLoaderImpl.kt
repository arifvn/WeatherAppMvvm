package com.squareit.weatherapp.util.image_loader

import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImageLoaderImpl(private val picasso: Picasso) : ImageLoader {
    override fun load(image: String, target: ImageView) {
        picasso.load(image).into(target)
    }
}