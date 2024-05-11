package ru.pyroman.news.domain.divkit.usecase

import ru.pyroman.news.domain.divkit.model.ViewPatchData
import ru.pyroman.news.domain.divkit.repository.DivkitRepository

class GetViewPatchDataUseCase internal constructor(
    private val divkitRepository: DivkitRepository
) {

    suspend fun execute(path: String): ViewPatchData {
        return divkitRepository.getViewPatchData(path)
    }
}