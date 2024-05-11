package ru.pyroman.news.data.divkit.datasource.network

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.modules.SerializersModule
import ru.pyroman.news.data.divkit.datasource.network.httpclient.DivkitHttpClient
import ru.pyroman.news.data.divkit.datasource.network.httpclient.ViewRequestParams
import ru.pyroman.news.data.divkit.dto.PatchDataDto
import ru.pyroman.news.data.divkit.dto.ViewDataDto

internal class DivkitNetworkDataSource(
    private val divkitHttpClient: DivkitHttpClient,
) {

    private val json by lazy {
        Json {
            serializersModule = SerializersModule {}
        }
    }

    suspend fun getViewData(path: String): ViewDataDto {
        val requestParams = ViewRequestParams(
            path = path,
        )
        val response = json.parseToJsonElement(
            divkitHttpClient.getView(requestParams)
        ).jsonObject

        val rawDivData = response["divan"]?.toString()

        return ViewDataDto(
            rawDivData = rawDivData,
        )
    }

    suspend fun getViewPatchData(path: String): PatchDataDto {
        val response = json.parseToJsonElement(
            divkitHttpClient.getPatch(path)
        ).jsonObject

        val rawPatchData = response["divanPatch"]?.toString()

        return PatchDataDto(
            rawPatchData = rawPatchData,
        )
    }
}