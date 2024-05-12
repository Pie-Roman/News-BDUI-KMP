package ru.pyroman.news.common.umbrella

import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.feature.divkit.custom.divkitCustomModule
import ru.pyroman.news.feature.divkit.divkitModule

val androidUmbrellaModule = module("androidUmbrellaModule") {
    importAll(
        divkitModule,
        divkitCustomModule,
    )
}