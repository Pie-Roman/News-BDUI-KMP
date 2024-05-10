package ru.pyroman.news.feature.divkit.custom

import android.view.View
import android.view.ViewGroup
import com.yandex.div.core.view2.Div2View
import com.yandex.div2.DivCustom

abstract class AbstractDivCustomViewAdapter<T : View> {

    abstract val customType: String

    open fun bindView(view: T, div: DivCustom, divView: Div2View) = Unit

    abstract fun createView(): T

    protected open fun releaseView(view: T, div: DivCustom) = Unit

    fun release(view: T, div: DivCustom) {
        releaseView(view, div)
        with(view) {
            (parent as? ViewGroup)?.removeView(this)
        }
    }
}