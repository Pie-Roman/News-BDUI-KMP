package ru.pyroman.news.data.divkit.datasource.network.httpclient

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.http.HttpMethod
import io.ktor.http.encodedPath

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
                encodedPath = viewRequestParams.path
            }
        }.body()
    }

    suspend fun getPatch(path: String): String {
        return httpClient.request {
            url {
                method = HttpMethod.Get
                protocol = config.protocol
                host = config.host
                encodedPath = path
            }
        }.body()
    }
}