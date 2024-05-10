package ru.pyroman.news.feature.divkit.imageloader

import android.content.Context
import com.bumptech.glide.Glide
import ru.pyroman.news.feature.divkit.imageloader.DivImageLoaderFactory
import ru.pyroman.news.feature.divkit.imageloader.GlideDivImageLoader

internal class GlideDivImageLoaderFactory : DivImageLoaderFactory {

    override fun create(context: Context): GlideDivImageLoader {
        return GlideDivImageLoader(
            requestManager = lazy { Glide.with(context) }
        )
    }
}