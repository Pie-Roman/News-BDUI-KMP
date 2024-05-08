package ru.pyroman.news.data.divkit.datasource.network.httpclient

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.http.HttpMethod
import io.ktor.http.path

internal class DivkitHttpClient(
    private val httpClient: HttpClient,
    private val config: DivkitHttpClientConfig,
) {

    suspend fun getView(viewRequestParams: ViewRequestParams): String {
        return httpClient.request {
            url {
                method = HttpMethod.Get
                protocol = config.protocol
                host = config.host
                path(viewRequestParams.path)
            }
        }.body()
    }
}