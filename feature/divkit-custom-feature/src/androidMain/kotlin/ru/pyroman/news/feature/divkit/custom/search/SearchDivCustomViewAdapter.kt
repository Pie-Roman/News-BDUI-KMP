package ru.pyroman.news.feature.divkit.custom.search

import android.content.Context
import ru.pyroman.news.feature.divkit.custom.AbstractDivCustomViewAdapter
import ru.pyroman.news.feature.divkit.custom.DivCustomType
import ru.pyroman.news.feature.search.presenter.SearchPresenterFactory
import ru.pyroman.news.feature.search.view.SearchView
import ru.pyroman.news.feature.search.view.AndroidSearchViewArgs

class SearchDivCustomViewAdapter(
    private val context: Context,
    private val searchPresenterFactory: SearchPresenterFactory,
) : AbstractDivCustomViewAdapter<SearchView>() {

    override val customType = DivCustomType.SEARCH.customType

    override fun createView(): SearchView {
        val viewArgs = AndroidSearchViewArgs()
        val searchView = SearchView(
            viewArgs = viewArgs,
            searchPresenterFactory = searchPresenterFactory,
            context = context,
        )

        return searchView
    }
}