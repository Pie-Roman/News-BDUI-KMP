package ru.pyroman.news.data.divkit.datasource.network.httpclient

import io.ktor.http.URLProtocol

internal class DivkitHttpClientConfig(
    val host: String,
    val protocol: URLProtocol,
)