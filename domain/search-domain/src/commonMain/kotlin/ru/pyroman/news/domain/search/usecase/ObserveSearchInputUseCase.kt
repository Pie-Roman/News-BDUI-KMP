package ru.pyroman.news.domain.search.usecase

import ru.pyroman.news.domain.search.repository.SearchRepository

class ObserveSearchInputUseCase internal constructor(
    private val searchRepository: SearchRepository,
) {

    suspend fun execute(observer: (String) -> Unit) {
        return searchRepository.observeSearchInput(observer)
    }
}