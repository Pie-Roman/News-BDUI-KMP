package ru.pyroman.news.domain.divkit.repository

import ru.pyroman.news.domain.divkit.model.ViewData

interface DivkitRepository {

    suspend fun getViewData(path: String): ViewData
}