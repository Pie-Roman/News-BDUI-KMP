package ru.pyroman.news.domain.divkit.usecase

import ru.pyroman.news.domain.divkit.model.ViewData
import ru.pyroman.news.domain.divkit.repository.DivkitRepository

class GetViewDataUseCase internal constructor(
    private val divkitRepository: DivkitRepository
) {

    suspend fun execute(path: String): ViewData {
        return divkitRepository.getViewData(path)
    }
}