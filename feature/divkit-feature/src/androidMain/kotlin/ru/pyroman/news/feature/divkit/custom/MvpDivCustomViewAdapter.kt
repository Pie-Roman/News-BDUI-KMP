package ru.pyroman.news.feature.divkit.custom

import android.view.View
import com.yandex.div.core.view2.Div2View
import com.yandex.div2.DivCustom
import ru.pyroman.news.base.uikit.mvp.MvpDelegate
import ru.pyroman.news.base.uikit.mvp.MvpView

abstract class MvpDivCustomViewAdapter<T : View> : AbstractDivCustomViewAdapter<T>(), MvpView {

    protected abstract fun provideMvpDelegate(): MvpDelegate<*>

    private var mvpDelegate: MvpDelegate<*>? = null

    override fun bindView(view: T, div: DivCustom, divView: Div2View) {
        super.bindView(view, div, divView)
        mvpDelegate = provideMvpDelegate().apply {
            onCreate()
            onAttach()
        }
    }

    override fun releaseView(view: T, div: DivCustom) {
        super.releaseView(view, div)
        mvpDelegate?.onDetach()
        mvpDelegate?.onDestroy()
    }
}