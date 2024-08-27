package cl.antoinette.monitor_politico_econmico.data.network

import android.util.Log
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.BASE_URL_DIP_ACT
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.END_POINT_DIP_ACT
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.TAG
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import javax.inject.Inject

class DiputadosWebScrapCallProvider @Inject constructor() {
   companion object {
      /*LEGISLATIVO*/
      fun getDiputadosActuales(): Document {
         val url = "${BASE_URL_DIP_ACT}${END_POINT_DIP_ACT}"
         val jsoup = Jsoup
            .connect(url)
            .get()
         Log.d(TAG, "getDiputadosActuales: $jsoup")
         return jsoup
      }

   }
}