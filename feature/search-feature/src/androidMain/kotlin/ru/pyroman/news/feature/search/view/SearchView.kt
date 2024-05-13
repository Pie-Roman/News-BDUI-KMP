package ru.pyroman.news.feature.search.view

import android.content.Context
import android.text.TextWatcher
import android.view.LayoutInflater
import androidx.core.widget.addTextChangedListener
import ru.pyroman.mvpkmp.MvpDelegate.Companion.mvpDelegate
import ru.pyroman.mvpkmp.framelayout.MvpFrameLayout
import ru.pyroman.news.feature.search.databinding.ViewSearchBinding
import ru.pyroman.news.feature.search.presenter.SearchPresenterFactory

class SearchView(
    searchPresenterFactory: SearchPresenterFactory,
    context: Context
) : MvpFrameLayout(context), SearchMvpView {

    override val mvpDelegate = mvpDelegate {
        searchPresenterFactory.create()
    }

    private val binding: ViewSearchBinding =
        ViewSearchBinding.inflate(LayoutInflater.from(this.context), this, true)
    private var searchInputTextWatcher: TextWatcher? = null
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
}