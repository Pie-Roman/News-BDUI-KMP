package ru.pyroman.news.feature.search

import org.kodein.di.DI
import org.kodein.di.instance
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.module.Module
import ru.pyroman.news.common.core.di.module.ModuleBridge
import ru.pyroman.news.common.core.di.provider
import ru.pyroman.news.common.core.di.singleton
import ru.pyroman.news.data.search.searchDataCommonModule
import ru.pyroman.news.domain.search.searchDomainCommonModule
import ru.pyroman.news.feature.search.presenter.SearchPresenterFactory
import ru.pyroman.news.feature.search.usecases.SearchUseCases

object SearchModuleAssembler : Module() {

    override val name = "searchModule"

    private val searchCommonModule = module("searchCommonModule") {
        importAll(
            searchDomainCommonModule,
            searchDataCommonModule,
        )

        provider {
           SearchUseCases(
               setSearchInputUseCase = instance(),
               observeSearchInputUseCase = instance(tag = "ObserveSearchInputUseCase"),
           )
        }

        singleton(
            tag = "SearchPresenterFactory"
        ) {
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

abstract class SearchModuleBridge: ModuleBridge()