package ru.pyroman.news.feature.divkit.custom

import android.content.Context
import android.view.View
import com.yandex.div.core.DivCustomContainerViewAdapter
import com.yandex.div.core.state.DivStatePath
import com.yandex.div.core.view2.Div2View
import com.yandex.div2.DivCustom

internal class DivCustomContainerViewAdapterImpl(
    private val context: Context,
    adaptersProvider: DivCustomViewAdaptersProvider,
) : DivCustomContainerViewAdapter {

    private val adaptersMap = adaptersProvider.provide().associateBy { adapter ->
        adapter.customType
    }
    override fun bindView(view: View, div: DivCustom, divView: Div2View, path: DivStatePath) {
        adaptersMap[div.customType]?.unsafeBindView(view, div, divView)
    }

    override fun createView(div: DivCustom, divView: Div2View, path: DivStatePath): View {
        return adaptersMap[div.customType]?.createView() ?: View(context)
    }

    override fun isCustomTypeSupported(type: String): Boolean {
        return adaptersMap.containsKey(type)
    }

    override fun release(view: View, div: DivCustom) {
        adaptersMap[div.customType]?.unsafeRelease(view, div)
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T> AbstractDivCustomViewAdapter<T>.unsafeBindView(
        view: View,
        div: DivCustom,
        divView: Div2View,
    ) where T : View = bindView(view as T, div, divView)

    @Suppress("UNCHECKED_CAST")
    private fun <T> AbstractDivCustomViewAdapter<T>.unsafeRelease(
        view: View,
        div: DivCustom,
    ) where T : View = release(view as T, div)
}