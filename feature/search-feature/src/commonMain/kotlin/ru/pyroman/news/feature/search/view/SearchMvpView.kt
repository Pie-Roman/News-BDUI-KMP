package ru.pyroman.news.feature.search.view

import ru.pyroman.mvpkmp.MvpDelegate
import ru.pyroman.mvpkmp.MvpDelegate.Companion.mvpDelegate
import ru.pyroman.mvpkmp.MvpView
import ru.pyroman.news.feature.search.presenter.SearchPresenter

interface SearchMvpView : MvpView {

    fun registerOnSearchInput(onSearchInput: (String) -> Unit)

    fun registerOnCancelClick(onCancelClick: () -> Unit)

    fun unregisterOnSearchInput()

    fun unregisterOnCancelClick()

    fun clearSearchInput()

    companion object {

        @Suppress("Unused")
        fun SearchMvpView.makeMvpDelegate(presenterFactory: () -> SearchPresenter): MvpDelegate<MvpView> {
            return mvpDelegate { presenterFactory() }
        }
    }
}