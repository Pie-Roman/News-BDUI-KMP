package ru.pyroman.news.feature.search.presenter

import ru.pyroman.news.base.uikit.presenter.BaseMvpPresenter
import ru.pyroman.news.common.core.di.Inject.instance
import ru.pyroman.news.feature.search.usecases.SearchUseCases
import ru.pyroman.news.feature.search.view.SearchMvpView

class SearchPresenter : BaseMvpPresenter<SearchMvpView>() {

    private val useCases: SearchUseCases = instance()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        view?.registerOnSearchInput { searchInput ->
            launch(
                block = {
                    useCases.setSearchInput(searchInput)
                }
            )
        }

        launch(
            block =  {
                useCases.observeSearchInput { searchInput ->
                    view?.observeSearchInput(searchInput)
                }
            }
        )

        view?.registerOnCancelClick {
            view?.clearSearchInput()
        }
    }

    override fun detachView() {
        view?.unregisterOnSearchInput()
        view?.unregisterOnCancelClick()
        super.detachView()
    }
}