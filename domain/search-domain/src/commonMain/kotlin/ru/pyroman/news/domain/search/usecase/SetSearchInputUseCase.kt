package ru.pyroman.news.domain.search.usecase

import ru.pyroman.news.domain.search.repository.SearchRepository

class SetSearchInputUseCase internal constructor(
    private val searchRepository: SearchRepository,
) {

    suspend fun execute(searchInput: String) {
        return searchRepository.setSearchInput(searchInput)
    }
}