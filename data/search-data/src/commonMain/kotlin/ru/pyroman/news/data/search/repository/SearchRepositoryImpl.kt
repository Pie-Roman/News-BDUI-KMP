package ru.pyroman.news.data.search.repository

import ru.pyroman.news.data.search.datasource.cache.SearchCacheDataSource
import ru.pyroman.news.domain.search.repository.SearchRepository

internal class SearchRepositoryImpl(
    private val cacheDataSource: SearchCacheDataSource,
) : SearchRepository {

    override suspend fun setSearchInput(searchInput: String) {
        return cacheDataSource.setSearchInput(searchInput)
    }

    override suspend fun observeSearchInput(observer: (String) -> Unit) {
        return cacheDataSource.observeSearchInput(observer)
    }
}