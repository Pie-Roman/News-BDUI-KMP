package ru.pyroman.news.android

import android.app.Application
import ru.pyroman.news.common.core.platform.AndroidPlatformConfiguration
import ru.pyroman.news.common.umbrella.PlatformSDK
import ru.pyroman.news.common.umbrella.androidUmbrellaModule

class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initPlatformSdk()
    }

    private fun initPlatformSdk() {
        PlatformSDK.initPlatform(
            configuration = AndroidPlatformConfiguration(applicationContext),
            platformModule = androidUmbrellaModule,
        )
    }
}