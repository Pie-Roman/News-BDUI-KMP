package ru.pyroman.news.feature.search

import org.kodein.di.DI
import ru.pyroman.news.common.core.di.Inject.instance
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.module.Module
import ru.pyroman.news.common.core.di.module.ModuleBridge
import ru.pyroman.news.common.core.di.provider
import ru.pyroman.news.common.core.di.singleton
import ru.pyroman.news.feature.search.presenter.SearchPresenterFactory
import ru.pyroman.news.feature.search.usecases.SearchUseCases

object SearchModuleAssembler : Module() {

    override val name = "searchModule"

    private val searchCommonModule = module("searchCommonModule") {
        provider {
           SearchUseCases()
        }

        singleton {
            SearchPresenterFactory()
        }
    }

    fun assembleModule(
        childModules: List<DI.Module>,
        bridge: SearchModuleBridge,
    ) = assemble(
        childModules = childModules + searchCommonModule,
        bridge = bridge,
    )
}

abstract class SearchModuleBridge: ModuleBridge() {

    @Suppress("Unused")
    companion object {
        fun searchPresenterFactoryInstance(): SearchPresenterFactory = instance()
    }
}