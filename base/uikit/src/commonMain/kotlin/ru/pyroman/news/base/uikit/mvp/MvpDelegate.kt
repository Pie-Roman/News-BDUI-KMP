package ru.pyroman.news.base.uikit.mvp

class MvpDelegate<out View : MvpView> private constructor(
    private var view: View?,
    private val presenterProvider: () -> MvpPresenter<View>,
) {

    private var presenter: MvpPresenter<View>? = null
    private var isAttached: Boolean = false

    fun onCreate() {
        if (presenter == null) {
            presenter = presenterProvider()
        }
    }

    fun onAttach() {
        if (!isAttached) {
            view?.let {
                presenter?.attachView(it)
                isAttached = true
            }
        }
    }

    fun onDetach() {
        if (isAttached) {
            view = null
            presenter?.detachView()
            isAttached = false
        }
    }

    fun onDestroy() {
        presenter = null
    }

    companion object {
        fun <View : MvpView> View.mvpDelegate(
            presenterProvider: () -> MvpPresenter<View>
        ) = MvpDelegate(
            view = this,
            presenterProvider = presenterProvider,
        )
    }
}