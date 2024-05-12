package ru.pyroman.news.feature.divkit.custom

import ru.pyroman.news.feature.divkit.custom.search.SearchDivCustomViewAdapter

internal class DivCustomViewAdaptersProviderImpl(
    private val searchDivCustomViewAdapter: SearchDivCustomViewAdapter,
) : DivCustomViewAdaptersProvider {

    override fun provide(): List<AbstractDivCustomViewAdapter<*>> = listOf(
        searchDivCustomViewAdapter,
    )
}