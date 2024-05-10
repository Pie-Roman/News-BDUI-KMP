package ru.pyroman.news.data.divkit.datasource.network.httpclient

import io.ktor.http.URLProtocol

internal class DivkitHttpClientConfigProvider {

    fun provide(): DivkitHttpClientConfig {
        return DivkitHttpClientConfig(
            host = "127.0.0.1:8080",
            protocol = URLProtocol.HTTP,
        )
    }
}