package ru.pyroman.news.feature.divkit.custom

import org.kodein.di.DI
import ru.pyroman.news.common.core.di.module.Module
import ru.pyroman.news.common.core.di.module.ModuleBridge

object DivkitCustomModuleAssembler : Module() {

    override val name = "divkitCustomModule"

    fun assembleModule(
        childModules: List<DI.Module>,
        bridge: DivkitCustomModuleBridge,
    ) = assemble(
        childModules = childModules,
        bridge = bridge,
    )
}

abstract class DivkitCustomModuleBridge: ModuleBridge()