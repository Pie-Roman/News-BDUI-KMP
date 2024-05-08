package ru.pyroman.news.data.divkit

import org.kodein.di.instance
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.provider
import ru.pyroman.news.common.core.di.singleton
import ru.pyroman.news.data.divkit.datasource.network.DivkitNetworkDataSource
import ru.pyroman.news.data.divkit.datasource.network.httpclient.DivkitHttpClient
import ru.pyroman.news.data.divkit.datasource.network.httpclient.DivkitHttpClientConfigProvider
import ru.pyroman.news.data.divkit.mapper.ViewDataMapper
import ru.pyroman.news.data.divkit.repository.DivkitRepositoryImpl
import ru.pyroman.news.domain.divkit.repository.DivkitRepository

val divkitDataCommonModule = module("divkitDataCommonModule") {

    singleton {
        DivkitHttpClientConfigProvider().provide()
    }

    singleton {
        DivkitHttpClient(
            httpClient = instance(),
            config = instance(),
        )
    }

    provider<DivkitNetworkDataSource> {
        DivkitNetworkDataSource(
            divkitHttpClient = instance(),
        )
    }

    provider<ViewDataMapper> {
        ViewDataMapper()
    }

    provider<DivkitRepository> {
        DivkitRepositoryImpl(
            mapper = instance(),
            networkDataSource = instance(),
        )
    }
}