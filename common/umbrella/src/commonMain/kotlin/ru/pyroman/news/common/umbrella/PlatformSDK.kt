package ru.pyroman.news.common.umbrella

import org.kodein.di.DI
import org.kodein.di.direct
import ru.pyroman.news.common.core.di.Inject
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.singleton
import ru.pyroman.news.common.core.network.networkModule
import ru.pyroman.news.common.core.platform.PlatformConfiguration

object PlatformSDK {

    fun initPlatform(
        configuration: PlatformConfiguration,
        platformModule: DI.Module,
    ) {
        val platformConfigurationModule = module("platformConfiguration") {
            singleton { configuration }
        }

        Inject.createDependencies(
            DI {
                importAll(
                    platformConfigurationModule,
                    platformModule,
                    networkModule,
                )
            }.direct
        )
    }
}