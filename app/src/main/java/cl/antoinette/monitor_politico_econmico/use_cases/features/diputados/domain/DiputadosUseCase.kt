package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import cl.antoinette.monitor_politico_econmico.service.StaticUtils
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data.DiputadosWebScrapCallProvider
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain.model.DiputadoObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.util.stream.Collectors
import javax.inject.Inject

class DiputadosUseCase @Inject constructor() {
    var allDiputadosActuales = MutableLiveData<MutableList<DiputadoObject>>(mutableListOf())

    init {
        getDiputadosDocument()
    }

    private fun getDiputadosDocument() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val diputadosActualesList = mutableListOf<DiputadoObject>()
                val document: Document = DiputadosWebScrapCallProvider.getDiputadosActuales()
                val articleElement: Elements = document.select("article.${StaticUtils.GRID_DIP_ACT}")
                val h4Elements = articleElement.select(StaticUtils.H4_DIP_ACT).eachText()
                val nameList = h4Elements.stream().collect(Collectors.toList())
                val webpage = articleElement.select("a").eachAttr(StaticUtils.HREF_DIP_ACT).stream()
                    .collect(Collectors.toList())
                val imagesList =
                    articleElement.select(StaticUtils.IMG_DIP_ACT).eachAttr(StaticUtils.SRC_DIP_ACT)
                        .stream().collect(Collectors.toList())
                var countAttr = 0
                if (webpage.size / 3 == nameList.size) {
                    val oldValueOne = "Sr. "
                    val oldValueTwo = "Sra. "
                    val newValue = ""

                    for ((i, f) in imagesList.withIndex()) {
                        diputadosActualesList.add(
                            DiputadoObject(
                                nombre = nameList[i].replace(oldValueOne, newValue)
                                    .replace(oldValueTwo, newValue),
                                paginaWeb = "${StaticUtils.BASE_URL_DIP_ACT}${StaticUtils.DIPUTADOS_DIP_ACT}${webpage[countAttr]}",
                                picture = "${StaticUtils.BASE_URL_DIP_ACT}${f}"
                            )
                        )
                        countAttr += 3
                    }
                }
                allDiputadosActuales.postValue(diputadosActualesList)
            } catch (e: Exception) {
                Log.e("ERRORRRRR ---->", e.toString())
            }
        }
    }
}


