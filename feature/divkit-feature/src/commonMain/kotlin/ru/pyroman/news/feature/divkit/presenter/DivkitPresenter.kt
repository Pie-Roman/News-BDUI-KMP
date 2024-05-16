package ru.pyroman.news.feature.divkit.presenter

import ru.pyroman.news.base.uikit.mvp.BaseMvpPresenter
import ru.pyroman.news.common.core.di.Inject.instance
import ru.pyroman.news.feature.divkit.usecases.DivkitUseCases
import ru.pyroman.news.feature.divkit.view.DivkitMvpView
import ru.pyroman.news.feature.divkit.view.DivkitViewArgs

class DivkitPresenter(
    private val viewArgs: DivkitViewArgs,
) : BaseMvpPresenter<DivkitMvpView>() {

    private val useCases: DivkitUseCases = instance()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        view?.showLoading()

        launch(
            block = {
                useCases.getViewData(viewArgs.query)
            },
            onSuccess = { viewData ->
                view?.showView(viewData)
            },
            onError = { _, _ ->
                view?.showError()
            }
        )
    }
}