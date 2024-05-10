package ru.pyroman.news.feature.divkit.custom

import org.kodein.di.DI
import ru.pyroman.news.common.core.di.provider

val divkitCustomModule = DivkitCustomModuleAssembler.apply {
    assembleModule(
        childModules = emptyList(),
        bridge = DivkitCustomModuleBridgeImpl(),
    )
}.instance

private class DivkitCustomModuleBridgeImpl : DivkitCustomModuleBridge() {

    override fun provideNativeInstances(builder: DI.Builder) {
        with(builder) {
            provider<DivCustomViewAdaptersProvider> {
                DivCustomViewAdaptersProviderImpl(

                )
            }
        }
    }
}