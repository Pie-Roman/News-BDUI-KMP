package ru.pyroman.news.feature.search.usecases

import ru.pyroman.news.domain.search.usecase.ObserveSearchInputUseCase
import ru.pyroman.news.domain.search.usecase.SetSearchInputUseCase

internal class SearchUseCases(
    private val setSearchInputUseCase: SetSearchInputUseCase,
    private val observeSearchInputUseCase: ObserveSearchInputUseCase,
) {

    suspend fun setSearchInput(searchInput: String) {
        return setSearchInputUseCase.execute(searchInput)
    }

    suspend fun observeSearchInput(observer: (String) -> Unit) {
        return observeSearchInputUseCase.execute(observer)
    }
}