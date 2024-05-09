package ru.pyroman.news.feature.divkit

import com.yandex.div.core.DivCustomContainerViewAdapter
import org.kodein.di.DI
import org.kodein.di.instance
import ru.pyroman.news.common.core.di.provider
import ru.pyroman.news.common.core.di.singleton
import ru.pyroman.news.common.core.platform.di.contextInstance
import ru.pyroman.news.feature.divkit.configuration.DivConfigurationFactory
import ru.pyroman.news.feature.divkit.context.DivContextFactory
import ru.pyroman.news.feature.divkit.custom.DivCustomContainerViewAdapterImpl
import ru.pyroman.news.feature.divkit.divview.DivViewFactory
import ru.pyroman.news.feature.divkit.imageloader.DivImageLoaderFactory
import ru.pyroman.news.feature.divkit.imageloader.GlideDivImageLoaderFactory

val divkitModule = DivkitModuleAssembler.apply {
    assembleModule(
        childModules = listOf(

        ),
        bridge = DivkitModuleBridgeImpl(),
    )
}.instance

private class DivkitModuleBridgeImpl : DivkitModuleBridge() {

    override fun provideNativeInstances(builder: DI.Builder) {
        with(builder) {
            provider<DivImageLoaderFactory> {
                GlideDivImageLoaderFactory()
            }

            provider<DivCustomContainerViewAdapter> {
                DivCustomContainerViewAdapterImpl(
                    context = contextInstance(),
                    adaptersProvider = instance(),
                )
            }

            provider {
                DivConfigurationFactory(
                    imageLoaderFactory = instance(),
                    divCustomContainerViewAdapter = instance(),
                )
            }

            singleton {
                DivContextFactory(
                    divConfigurationFactory = instance(),
                    context = contextInstance(),
                )
            }

            provider<DivViewFactory> {
                DivViewFactory(
                    contextFactory = instance(),
                )
            }
        }
    }
}