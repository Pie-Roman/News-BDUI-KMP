package ru.pyroman.news.feature.search.view.fragment

import android.os.Bundle
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import ru.pyroman.mvpkmp.MvpDelegate.Companion.mvpDelegate
import ru.pyroman.mvpkmp.fragment.MvpFragment
import ru.pyroman.news.base.uikit.utils.parcelableArg
import ru.pyroman.news.common.core.di.Inject.instance
import ru.pyroman.news.feature.search.databinding.FragmentSearchBinding
import ru.pyroman.news.feature.search.presenter.SearchPresenterFactory
import ru.pyroman.news.feature.search.view.SearchMvpView
import ru.pyroman.news.feature.search.view.args.AndroidSearchViewArgs

class SearchFragment : MvpFragment(), SearchMvpView {

    override val mvpDelegate = mvpDelegate {
        searchPresenterFactory.create(
            viewArgs = args,
        )
    }

    private var _binding: FragmentSearchBinding? = null
    private val binding
        get() = requireNotNull(_binding)

    private val searchPresenterFactory: SearchPresenterFactory = instance()

    private val args by parcelableArg<AndroidSearchViewArgs>(ARGUMENTS)

    private var searchInputTextWatcher: TextWatcher? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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

    companion object {
        private const val ARGUMENTS = "arguments"

        fun withArgs(viewArgs: AndroidSearchViewArgs): Bundle {
            return Bundle().apply {
                putParcelable(ARGUMENTS, viewArgs)
            }
        }
    }
}