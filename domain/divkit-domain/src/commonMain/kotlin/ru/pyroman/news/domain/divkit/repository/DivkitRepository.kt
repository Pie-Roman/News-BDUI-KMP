package ru.pyroman.news.domain.divkit.repository

import ru.pyroman.news.domain.divkit.model.ViewData
import ru.pyroman.news.domain.divkit.model.ViewPatchData

interface DivkitRepository {

    suspend fun getViewData(path: String): ViewData

    suspend fun getViewPatchData(path: String): ViewPatchData
}