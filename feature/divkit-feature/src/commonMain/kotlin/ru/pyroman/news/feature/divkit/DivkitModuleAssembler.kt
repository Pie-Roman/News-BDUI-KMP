package ru.pyroman.news.feature.divkit

import org.kodein.di.DI
import org.kodein.di.instance
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.module.Module
import ru.pyroman.news.common.core.di.module.ModuleBridge
import ru.pyroman.news.common.core.di.provider
import ru.pyroman.news.common.core.di.singleton
import ru.pyroman.news.data.divkit.divkitDataCommonModule
import ru.pyroman.news.domain.divkit.divkitDomainCommonModule
import ru.pyroman.news.feature.divkit.presenter.DivkitPresenterFactory
import ru.pyroman.news.feature.divkit.usecases.DivkitUseCases

object DivkitModuleAssembler : Module() {

    override val name = "divkitModule"

    private val divkitCommonModule = module("divkitCommonModule") {
        importAll(
            divkitDomainCommonModule,
            divkitDataCommonModule,
        )

        provider {
            DivkitUseCases(
                getViewDataUseCase = instance()
            )
        }

        singleton(
            tag = "DivkitPresenterFactory"
        ) {
            DivkitPresenterFactory()
        }
    }

    fun assembleModule(
        childModules: List<DI.Module>,
        bridge: DivkitModuleBridge,
    ) = assemble(
        childModules = childModules + divkitCommonModule,
        bridge = bridge,
    )
}

abstract class DivkitModuleBridge: ModuleBridge()