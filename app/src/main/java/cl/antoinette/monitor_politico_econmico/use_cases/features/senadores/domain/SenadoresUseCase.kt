package cl.antoinette.monitor_politico_econmico.use_cases.features.senadores.domain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import cl.antoinette.monitor_politico_econmico.service.StaticUtils
import cl.antoinette.monitor_politico_econmico.service.StaticUtils.Companion.BASE_URL_SEN_ACT
import cl.antoinette.monitor_politico_econmico.use_cases.features.senadores.domain.objects.SenadorObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import javax.inject.Inject

class SenadoresUseCase @Inject constructor() {
    private var senadoresList = MutableLiveData<MutableList<SenadorObject>?>(mutableListOf())

    init {
        CoroutineScope(Dispatchers.IO).launch {
            getSenadoresDocument()
        }
    }

    suspend fun getSenadoresDocument(): MutableList<SenadorObject>? {
        try {
            val url = StaticUtils.PPAL_URL_SEN_ACT
            val document: Document = Jsoup.connect(url).get()
            val divElement: Elements = document.select("div.s0")
            val webpageList = divElement.select("a").eachAttr("href")
            val nameList = divElement.select("img").eachAttr("alt")
            val imagesList = divElement.select("img").eachAttr("src")

            imagesList.withIndex().forEach { (index, f) ->
                senadoresList.value?.add(
                    SenadorObject(
                        nombre = nameList[index].toString(),
                        paginaWeb = "${BASE_URL_SEN_ACT}${webpageList[index]}",
                        picture = "${BASE_URL_SEN_ACT}${f}"
                    )
                )
            }
            return senadoresList.value
        } catch (e: Exception) {
            Log.e("ERRORRRRR ---->", e.toString())
            return mutableListOf<SenadorObject>()
        }
    }
}