package ru.pyroman.news.base.uikit.mvp

import ru.pyroman.news.base.uikit.utils.WeakReference

@OptIn(kotlin.experimental.ExperimentalNativeApi::class)
open class MvpPresenter<View : MvpView> {

    protected val view: View?
        get() = _view?.get()

    private var _view: WeakReference<View>? = null
    private var isFirstLaunch = true

    protected open fun onFirstViewAttach() {

    }

    open fun attachView(view: View) {
        this._view = WeakReference(view)

        if (isFirstLaunch) {
            isFirstLaunch = false
            onFirstViewAttach()
        }
    }

    open fun detachView() {
        this._view?.clear()
    }
}