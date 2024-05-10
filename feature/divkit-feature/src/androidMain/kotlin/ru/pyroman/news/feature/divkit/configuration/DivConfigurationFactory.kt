package ru.pyroman.news.feature.divkit.configuration

import android.content.Context
import com.yandex.div.core.DivActionHandler
import com.yandex.div.core.DivConfiguration
import com.yandex.div.core.DivCustomContainerViewAdapter
import ru.pyroman.news.feature.divkit.imageloader.DivImageLoaderFactory

internal class DivConfigurationFactory(
    private val imageLoaderFactory: DivImageLoaderFactory,
    private val divCustomContainerViewAdapter: DivCustomContainerViewAdapter,
) {

    fun create(
        context: Context,
    ): DivConfiguration {
        val actionHandler = DivActionHandler()

        val builder = DivConfiguration.Builder(
            imageLoaderFactory.create(context)
        )
            .actionHandler(actionHandler)
            .divCustomContainerViewAdapter(divCustomContainerViewAdapter)

        return builder.build()
    }
}