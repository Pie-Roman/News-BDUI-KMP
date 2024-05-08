package ru.pyroman.news.data.divkit.repository

import ru.pyroman.news.data.divkit.datasource.network.DivkitNetworkDataSource
import ru.pyroman.news.data.divkit.mapper.ViewDataMapper
import ru.pyroman.news.domain.divkit.model.ViewData
import ru.pyroman.news.domain.divkit.repository.DivkitRepository

internal class DivkitRepositoryImpl(
    private val mapper: ViewDataMapper,
    private val networkDataSource: DivkitNetworkDataSource,
) : DivkitRepository {
    override suspend fun getViewData(path: String): ViewData {
        val dto = networkDataSource.getViewData(path)

        return mapper.map(dto)
    }
}