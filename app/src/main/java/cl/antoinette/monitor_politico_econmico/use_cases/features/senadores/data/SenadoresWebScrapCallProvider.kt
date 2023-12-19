package cl.antoinette.monitor_politico_econmico.use_cases.features.senadores.data

import cl.antoinette.monitor_politico_econmico.service.StaticUtils.Companion.BASE_URL_DIP_ACT
import cl.antoinette.monitor_politico_econmico.service.StaticUtils.Companion.END_POINT_DIP_ACT
import cl.antoinette.monitor_politico_econmico.service.StaticUtils.Companion.PPAL_URL_SEN_ACT
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import javax.inject.Inject

class SenadoresWebScrapCallProvider @Inject constructor() {
    companion object {
        /*LEGISLATIVO*/
        fun getDiputadosActuales(): Document {
            val url = PPAL_URL_SEN_ACT
            return Jsoup.connect(url).get()
        }

    }
}