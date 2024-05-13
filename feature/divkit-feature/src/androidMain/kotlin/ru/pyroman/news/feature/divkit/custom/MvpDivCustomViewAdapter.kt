package ru.pyroman.news.feature.divkit.custom

import android.view.View
import com.yandex.div.core.view2.Div2View
import com.yandex.div2.DivCustom
import ru.pyroman.mvpkmp.MvpDelegate
import ru.pyroman.mvpkmp.MvpView

abstract class MvpDivCustomViewAdapter<T : View> : AbstractDivCustomViewAdapter<T>(), MvpView {

    protected abstract val mvpDelegate: MvpDelegate<*>

    override fun bindView(view: T, div: DivCustom, divView: Div2View) {
        super.bindView(view, div, divView)
        mvpDelegate.onCreate()
        mvpDelegate.onAttach()
    }

    override fun releaseView(view: T, div: DivCustom) {
        super.releaseView(view, div)
        mvpDelegate.onDetach()
        mvpDelegate.onDestroy()
    }
}