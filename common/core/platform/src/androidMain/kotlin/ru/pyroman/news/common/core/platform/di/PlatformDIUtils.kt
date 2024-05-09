package ru.pyroman.news.common.core.platform.di

import android.content.Context
import org.kodein.di.DirectDIAware
import org.kodein.di.instance
import ru.pyroman.news.common.core.platform.AndroidPlatformConfiguration
import ru.pyroman.news.common.core.platform.PlatformConfiguration

fun DirectDIAware.contextInstance(): Context {
    val platformConfiguration = instance<PlatformConfiguration>()
            as AndroidPlatformConfiguration
    return platformConfiguration.androidContext
}