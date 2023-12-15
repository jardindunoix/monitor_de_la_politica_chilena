package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data

import cl.antoinette.monitor_politico_econmico.service.StaticUtils
import cl.antoinette.monitor_politico_econmico.service.StaticUtils.Companion.BASE_URL_DIP_ACT
import cl.antoinette.monitor_politico_econmico.service.StaticUtils.Companion.DIPUTADOS_DIP_ACT
import cl.antoinette.monitor_politico_econmico.service.StaticUtils.Companion.GRID_DIP_ACT
import cl.antoinette.monitor_politico_econmico.service.StaticUtils.Companion.H4_DIP_ACT
import cl.antoinette.monitor_politico_econmico.service.StaticUtils.Companion.HREF_DIP_ACT
import cl.antoinette.monitor_politico_econmico.service.StaticUtils.Companion.IMG_DIP_ACT
import cl.antoinette.monitor_politico_econmico.service.StaticUtils.Companion.SRC_DIP_ACT
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain.objects.DiputadoObject
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.util.stream.Collectors
import javax.inject.Inject

class DiputadosWebScrapCallProvider @Inject constructor() {
    companion object {
        /*LEGISLATIVO*/
        fun getDiputadosActuales(): MutableList<DiputadoObject> {
            val diputadosActualesList = mutableListOf<DiputadoObject>()
            val url = "${BASE_URL_DIP_ACT}${StaticUtils.END_POINT_DIP_ACT}"
            val document: Document = Jsoup.connect(url).get()
            val articleElement: Elements = document.select("article.${GRID_DIP_ACT}")
            val h4Elements = articleElement.select(H4_DIP_ACT).eachText()
            val nameList = h4Elements.stream().collect(Collectors.toList())
            val webpage = articleElement.select("a").eachAttr(HREF_DIP_ACT).stream()
                .collect(Collectors.toList())
            val imagesList =
                articleElement.select(IMG_DIP_ACT).eachAttr(SRC_DIP_ACT)
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
                            paginaWeb = "${BASE_URL_DIP_ACT}${DIPUTADOS_DIP_ACT}${webpage[countAttr]}",
                            picture = "${BASE_URL_DIP_ACT}${f}"
                        )
                    )
                    countAttr += 3
                }
            }
            return diputadosActualesList
        }

    }
}