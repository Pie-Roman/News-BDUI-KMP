package ru.pyroman.news.feature.search.view

import ru.pyroman.news.base.uikit.mvp.MvpDelegate
import ru.pyroman.news.base.uikit.mvp.MvpDelegate.Companion.mvpDelegate
import ru.pyroman.news.base.uikit.mvp.MvpView
import ru.pyroman.news.feature.search.presenter.SearchPresenter

interface SearchMvpView : MvpView {

    fun observeSearchInput(searchInput: String)

    fun registerOnSearchInput(onSearchInput: (String) -> Unit)

    fun registerOnSearchClick(onSearchClick: () -> Unit)

    fun registerOnCancelClick(onCancelClick: () -> Unit)

    fun unregisterOnSearchInput()

    fun unregisterOnSearchClick()

    fun unregisterOnCancelClick()

    fun focusSearchInput()

    fun clearSearchInput()

    companion object {

        @Suppress("Unused")
        fun SearchMvpView.makeMvpDelegate(presenterFactory: () -> SearchPresenter): MvpDelegate<MvpView> {
            return mvpDelegate { presenterFactory() }
        }
    }
}