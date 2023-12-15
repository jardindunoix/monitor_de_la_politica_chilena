package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data

import cl.antoinette.monitor_politico_econmico.service.StaticUtils
import cl.antoinette.monitor_politico_econmico.service.StaticUtils.Companion.BASE_URL_DIP_ACT
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import javax.inject.Inject

class DiputadosWebScrapCallProvider @Inject constructor() {
    companion object {
        /*LEGISLATIVO*/
        fun getDiputadosActuales(): Document {
            val url = "${BASE_URL_DIP_ACT}${StaticUtils.END_POINT_DIP_ACT}"
            return Jsoup.connect(url).get()
        }

    }
}