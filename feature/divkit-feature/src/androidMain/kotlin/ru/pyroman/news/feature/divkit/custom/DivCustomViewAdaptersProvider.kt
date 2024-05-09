package ru.pyroman.news.feature.divkit.custom

interface DivCustomViewAdaptersProvider {

    fun provide(): List<AbstractDivCustomViewAdapter<*>>
}