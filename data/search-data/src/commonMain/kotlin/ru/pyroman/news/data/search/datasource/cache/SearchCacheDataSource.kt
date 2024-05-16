package ru.pyroman.news.data.search.datasource.cache

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce

internal class SearchCacheDataSource {

    private val searchInputFlow = MutableStateFlow("")

    suspend fun setSearchInput(searchInput: String) {
        searchInputFlow.emit(searchInput)
    }

    suspend fun observeSearchInput(observer: (String) -> Unit) {
        searchInputFlow
            .debounce(timeoutMillis = 500L)
            .collect { searchInput ->
                observer(searchInput)
            }
    }
}