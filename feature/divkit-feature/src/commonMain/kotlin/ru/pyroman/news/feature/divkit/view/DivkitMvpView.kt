package ru.pyroman.news.feature.divkit.view

import ru.pyroman.news.base.uikit.mvp.MvpDelegate
import ru.pyroman.news.base.uikit.mvp.MvpDelegate.Companion.mvpDelegate
import ru.pyroman.news.base.uikit.mvp.MvpView
import ru.pyroman.news.domain.divkit.model.ViewData
import ru.pyroman.news.feature.divkit.presenter.DivkitPresenter

interface DivkitMvpView : MvpView {

    fun showView(viewData: ViewData)

    fun showLoading()

    fun showError()

    fun showNetworkError()

    companion object {

        @Suppress("Unused")
        fun DivkitMvpView.makeMvpDelegate(presenterFactory: () -> DivkitPresenter): MvpDelegate<MvpView> {
            return mvpDelegate { presenterFactory() }
        }
    }
}