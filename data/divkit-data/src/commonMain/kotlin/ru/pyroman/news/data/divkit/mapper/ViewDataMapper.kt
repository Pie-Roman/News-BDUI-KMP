package ru.pyroman.news.data.divkit.mapper

import ru.pyroman.news.data.divkit.dto.ViewDataDto
import ru.pyroman.news.domain.divkit.model.ViewData

internal class ViewDataMapper {
    fun map(dto: ViewDataDto): ViewData {
        val rawDivData = requireNotNull(dto.rawDivData)

        return ViewData(
            rawDivData = rawDivData,
        )
    }
}