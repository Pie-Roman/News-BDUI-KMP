package ru.pyroman.news.domain.search.repository

interface SearchRepository {
    suspend fun setSearchInput(searchInput: String)

    suspend fun observeSearchInput(observer: (String) -> Unit)
}