package ru.pyroman.news.feature.divkit.presenter

import ru.pyroman.news.feature.divkit.view.DivkitViewArgs

class DivkitPresenterFactory {

    fun create(viewArgs: DivkitViewArgs): DivkitPresenter {
        return DivkitPresenter(
            viewArgs = viewArgs
        )
    }
}