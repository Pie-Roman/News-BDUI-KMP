package ru.pyroman.news.domain.search

import ru.pyroman.news.common.core.di.Inject.instance
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.provider
import ru.pyroman.news.domain.search.usecase.ObserveSearchInputUseCase
import ru.pyroman.news.domain.search.usecase.SetSearchInputUseCase

val searchDomainCommonModule = module("searchDomainCommonModule") {

    provider {
        SetSearchInputUseCase(
            searchRepository = instance(),
        )
    }

    provider(
        tag = "ObserveSearchInputUseCase"
    ) {
        ObserveSearchInputUseCase(
            searchRepository = instance(),
        )
    }
}