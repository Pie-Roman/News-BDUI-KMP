package ru.pyroman.news.feature.search

val searchModule = SearchModuleAssembler.apply {
    assembleModule(
        childModules = listOf(),
        bridge = SearchModuleBridgeImpl(),
    )
}.instance

private class SearchModuleBridgeImpl : SearchModuleBridge()