package com.squareit.weatherapp.di

import com.squareit.weatherapp.util.image_loader.ImageLoader
import com.squareit.weatherapp.util.image_loader.ImageLoaderImpl
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(ActivityComponent::class)
class ImageLoaderModule {

    @ActivityContext
    @Provides
    fun providePicasso(): Picasso = Picasso.get()

    @ActivityContext
    @Provides
    fun provideImageLoaderImpl(picasso: Picasso): ImageLoader = ImageLoaderImpl(picasso)
}