package ru.pyroman.news.feature.search.presenter

import ru.pyroman.news.base.uikit.presenter.BaseMvpPresenter
import ru.pyroman.news.common.core.di.Inject.instance
import ru.pyroman.news.feature.search.usecases.SearchUseCases
import ru.pyroman.news.feature.search.view.SearchMvpView
import ru.pyroman.news.feature.search.view.SearchViewArgs

class SearchPresenter(
    private val viewArgs: SearchViewArgs,
) : BaseMvpPresenter<SearchMvpView>() {

    private val useCases: SearchUseCases = instance()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        view?.registerOnSearchInput {

        }
        view?.registerOnCancelClick {
            view?.clearSearchInput()
        }
    }

    override fun detachView() {
        view?.unregisterOnSearchInput()
        super.detachView()
    }
}