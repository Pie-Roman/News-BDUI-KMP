package ru.pyroman.news.feature.divkit.custom.search

import android.content.Context
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.yandex.div.core.expression.variables.DivVariableController
import com.yandex.div.core.view2.Div2View
import com.yandex.div.data.Variable
import com.yandex.div2.DivCustom
import ru.pyroman.mvpkmp.MvpDelegate.Companion.mvpDelegate
import ru.pyroman.news.feature.divkit.custom.DivCustomType
import ru.pyroman.news.feature.divkit.custom.MvpDivCustomViewAdapter
import ru.pyroman.news.feature.search.databinding.ViewSearchBinding
import ru.pyroman.news.feature.search.presenter.SearchPresenterFactory
import ru.pyroman.news.feature.search.view.SearchMvpView

class SearchDivCustomViewAdapter(
    private val context: Context,
    private val searchPresenterFactory: SearchPresenterFactory,
    private val divVariableController: DivVariableController,
) : MvpDivCustomViewAdapter<View>(), SearchMvpView {

    override val customType = DivCustomType.SEARCH.customType

    override val mvpDelegate = mvpDelegate {
        searchPresenterFactory.create()
    }

    private var searchInputVariableName: String? = null

    private var _binding: ViewSearchBinding? = null
    private val binding: ViewSearchBinding
        get() = requireNotNull(_binding)

    private var searchInputTextWatcher: TextWatcher? = null

    override fun createView(): View {
        return ViewSearchBinding.inflate(LayoutInflater.from(this.context)).apply {
            _binding = this
        }.root
    }

    override fun bindView(view: View, div: DivCustom, divView: Div2View) {
        super.bindView(view, div, divView)
        searchInputVariableName = div.customProps?.optString("keySearchInput")
    }

    override fun observeSearchInput(searchInput: String) {
        searchInputVariableName?.let { variableName ->
            divVariableController.putOrUpdate(
                Variable.StringVariable(
                    name = variableName,
                    defaultValue = searchInput,
                )
            )
        }

    }

    override fun registerOnSearchInput(onSearchInput: (String) -> Unit) = with(binding) {
        searchInputTextWatcher = searchTv.addTextChangedListener { searchInput ->
            onSearchInput(searchInput?.toString().orEmpty())
        }
    }

    override fun registerOnCancelClick(onCancelClick: () -> Unit) = with(binding) {
        cancelIv.setOnClickListener { onCancelClick() }
    }

    override fun unregisterOnSearchInput() = with(binding) {
        searchTv.removeTextChangedListener(searchInputTextWatcher)
        searchInputTextWatcher = null
    }

    override fun unregisterOnCancelClick() = with(binding) {
        cancelIv.setOnClickListener(null)
    }

    override fun clearSearchInput() = with(binding) {
        searchTv.text = null
    }

    override fun releaseView(view: View, div: DivCustom) {
        super.releaseView(view, div)
        _binding = null
    }
}