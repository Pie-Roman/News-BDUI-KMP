package ru.pyroman.news.common.core.network.ktor

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory

internal expect class HttpEngineFactory() {

    fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig>
}