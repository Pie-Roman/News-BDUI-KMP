package ru.pyroman.news.feature.search.presenter

import ru.pyroman.news.base.uikit.mvp.BaseMvpPresenter
import ru.pyroman.news.common.core.di.Inject.instance
import ru.pyroman.news.feature.search.usecases.SearchUseCases
import ru.pyroman.news.feature.search.view.SearchMvpView

class SearchPresenter : BaseMvpPresenter<SearchMvpView>() {

    private val useCases: SearchUseCases = instance()

    override fun attachView(view: SearchMvpView) {
        super.attachView(view)
        this.view?.registerOnSearchInput { searchInput ->
            launch(
                block = {
                    useCases.setSearchInput(searchInput)
                }
            )
        }

        launch(
            block =  {
                useCases.observeSearchInput { searchInput ->
                    this@SearchPresenter.view?.observeSearchInput(searchInput)
                }
            }
        )

        this.view?.registerOnCancelClick {
            this.view?.clearSearchInput()
        }

        this.view?.registerOnSearchClick {
            this.view?.focusSearchInput()
        }
    }

    override fun detachView() {
        view?.unregisterOnSearchInput()
        view?.unregisterOnSearchClick()
        view?.unregisterOnCancelClick()
        super.detachView()
    }
}