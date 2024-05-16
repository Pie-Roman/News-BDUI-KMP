package ru.pyroman.news.feature.divkit.imageloader

import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.yandex.div.core.images.BitmapSource
import com.yandex.div.core.images.CachedBitmap
import com.yandex.div.core.images.DivImageDownloadCallback
import com.yandex.div.core.images.DivImageLoader
import com.yandex.div.core.images.LoadReference

internal class GlideDivImageLoader(
    private val requestManager: Lazy<RequestManager>,
) : DivImageLoader {

    override fun loadImage(
        imageUrl: String,
        callback: DivImageDownloadCallback,
    ): LoadReference {
        val uri = Uri.parse(imageUrl)
        val glide = requestManager.value
        val target = glide
            .asBitmap()
            .load(uri)
            .skipMemoryCache(false)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .listener(callback.wrap { resource, from -> CachedBitmap(resource, uri, from) })
            .error(com.yandex.div.R.drawable.div_button_background)
            .into(NoopTarget())
        return LoadReference { glide.clear(target) }
    }

    override fun loadImage(imageUrl: String, imageView: ImageView): LoadReference =
        error("Must not be used")

    override fun loadImageBytes(
        imageUrl: String,
        callback: DivImageDownloadCallback,
    ): LoadReference {
        val uri = Uri.parse(imageUrl)
        val glide = requestManager.value
        val target = glide
            .asGif()
            .load(uri)
            .listener(
                callback.wrap { resource, from ->
                    val bytes = ByteArray(resource.buffer.remaining())
                    resource.buffer.get(bytes)
                    CachedBitmap(resource.firstFrame, bytes, uri, from)
                }
            )
            .error(com.yandex.div.R.drawable.div_button_background)
            .into(NoopTarget())
        return LoadReference { glide.clear(target) }
    }

    private fun <T> DivImageDownloadCallback.wrap(
        block: (resource: T, from: BitmapSource) -> CachedBitmap
    ): RequestListener<T> {

        return object : RequestListener<T> {

            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<T>,
                isFirstResource: Boolean
            ): Boolean {
                onError()
                return true
            }

            override fun onResourceReady(
                resource: T & Any,
                model: Any,
                target: Target<T>?,
                dataSource: DataSource,
                isFirstResource: Boolean
            ): Boolean {
                val from = when (dataSource) {
                    DataSource.REMOTE -> BitmapSource.NETWORK
                    DataSource.MEMORY_CACHE -> BitmapSource.MEMORY
                    DataSource.DATA_DISK_CACHE,
                    DataSource.RESOURCE_DISK_CACHE,
                    DataSource.LOCAL -> BitmapSource.DISK
                }
                onSuccess(block(resource, from))
                return true
            }
        }
    }
    private class NoopTarget<T : Any> : CustomTarget<T>() {

        override fun onResourceReady(resource: T, transition: Transition<in T>?) = Unit

        override fun onLoadCleared(placeholder: Drawable?) = Unit
    }
}