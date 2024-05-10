package ru.pyroman.news.domain.divkit

import ru.pyroman.news.common.core.di.Inject.instance
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.provider
import ru.pyroman.news.domain.divkit.usecase.GetViewDataUseCase

val divkitDomainCommonModule = module("divkitDomainCommonModule") {

    provider {
        GetViewDataUseCase(
            divkitRepository = instance(),
        )
    }
}