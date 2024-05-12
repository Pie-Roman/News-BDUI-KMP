package ru.pyroman.news.feature.search.usecases

import ru.pyroman.news.domain.search.usecase.SetSearchInputUseCase

internal class SearchUseCases(
    private val setSearchInputUseCase: SetSearchInputUseCase,
) {

    suspend fun setSearchInput(searchInput: String) {
        return setSearchInputUseCase.execute(searchInput)
    }
}