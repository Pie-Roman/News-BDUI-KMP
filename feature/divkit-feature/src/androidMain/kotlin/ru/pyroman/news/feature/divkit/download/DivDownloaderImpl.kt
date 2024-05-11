package ru.pyroman.news.feature.divkit.download

import com.yandex.div.core.downloader.DivDownloader
import com.yandex.div.core.downloader.DivPatchDownloadCallback
import com.yandex.div.core.images.LoadReference
import com.yandex.div.core.view2.Div2View
import com.yandex.div.data.DivParsingEnvironment
import com.yandex.div2.DivPatch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import ru.pyroman.news.domain.divkit.usecase.GetViewPatchDataUseCase

internal class DivDownloaderImpl(
    private val getViewPatchDataUseCase: GetViewPatchDataUseCase,
    private val environment: DivParsingEnvironment,
) : DivDownloader {
    override fun downloadPatch(
        divView: Div2View,
        downloadUrl: String,
        callback: DivPatchDownloadCallback
    ): LoadReference {
        val job = GlobalScope.launch {
            val divPatch = withContext(Dispatchers.IO) {
                val rawPatchData = getViewPatchDataUseCase.execute(downloadUrl)
                val json = JSONObject(rawPatchData.rawPatchData)
                val patch = json.getJSONObject("patch")
                val templates = json.optJSONObject("templates")
                if (templates != null) {
                    environment.parseTemplates(templates)
                }
                DivPatch(environment, patch)
            }

            withContext(Dispatchers.Main) {
                callback.onSuccess(divPatch)
            }
        }

        return LoadReference { job.cancel() }
    }
}