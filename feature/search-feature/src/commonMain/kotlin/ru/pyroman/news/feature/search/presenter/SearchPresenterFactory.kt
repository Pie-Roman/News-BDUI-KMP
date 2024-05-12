package ru.pyroman.news.feature.search.presenter

import ru.pyroman.news.feature.search.view.SearchViewArgs

class SearchPresenterFactory {

    fun create(viewArgs: SearchViewArgs): SearchPresenter {
        return SearchPresenter(
            viewArgs = viewArgs,
        )
    }
}