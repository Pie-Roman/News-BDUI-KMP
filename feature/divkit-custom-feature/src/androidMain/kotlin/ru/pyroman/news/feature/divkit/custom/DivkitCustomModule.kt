package ru.pyroman.news.feature.divkit.custom

import org.kodein.di.DI
import org.kodein.di.instance
import ru.pyroman.news.common.core.di.provider
import ru.pyroman.news.common.core.platform.di.contextInstance
import ru.pyroman.news.feature.divkit.custom.search.SearchDivCustomViewAdapter
import ru.pyroman.news.feature.search.searchModule

val divkitCustomModule = DivkitCustomModuleAssembler.apply {
    assembleModule(
        childModules = listOf(
            searchModule,
        ),
        bridge = DivkitCustomModuleBridgeImpl(),
    )
}.instance

private class DivkitCustomModuleBridgeImpl : DivkitCustomModuleBridge() {

    override fun provideNativeInstances(builder: DI.Builder) {
        with(builder) {
            provider {
                SearchDivCustomViewAdapter(
                    context = contextInstance(),
                    searchPresenterFactory = instance(),
                )
            }

            provider<DivCustomViewAdaptersProvider> {
                DivCustomViewAdaptersProviderImpl(
                    searchDivCustomViewAdapter = instance(),
                )
            }
        }
    }
}