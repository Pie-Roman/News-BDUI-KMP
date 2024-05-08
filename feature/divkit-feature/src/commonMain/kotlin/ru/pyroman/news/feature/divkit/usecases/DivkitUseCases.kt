package ru.pyroman.news.feature.divkit.usecases

import ru.pyroman.news.domain.divkit.model.ViewData
import ru.pyroman.news.domain.divkit.usecase.GetViewDataUseCase

internal class DivkitUseCases(
    private val getViewDataUseCase: GetViewDataUseCase,
) {

    suspend fun getViewData(path: String): ViewData {
        return getViewDataUseCase.execute(path)
    }
}