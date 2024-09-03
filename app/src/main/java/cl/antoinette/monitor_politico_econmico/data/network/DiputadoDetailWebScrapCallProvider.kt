package cl.antoinette.monitor_politico_econmico.data.network

import android.util.Log
import cl.antoinette.monitor_politico_econmico.data.network.model.DiputadoDetailNetworkModel
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.BASE_URL_DIP_ACT
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.TAG
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import javax.inject.Inject

class DiputadoDetailWebScrapCallProvider @Inject constructor() {

   suspend fun getDiputadoDetailNetwork(url: String): DiputadoDetailNetworkModel {
      try {
         val jsoup = Jsoup
            .connect(url)
            .get()

         val document: Document = jsoup

         val articleElement: Elements = document.select("section div.auxi div.grid-3 p")

         val picture = BASE_URL_DIP_ACT + document
            .select("form div.grid-2 img")
            .attr("src")
            .toString()

         val name = document
            .select("form div.grid-2 img")
            .attr("alt")
            .toString()
            .replace(
               "Diputada",
               ""
            )
            .replace(
               "Diputado",
               ""
            )
            .trim()


         Log.d(
            TAG,
            "getDiputadoDetail: $picture $name "
         )

         val data = articleElement
            .toString()
            .replace(
               "<p>",
               ""
            )
            .replace(
               "</p>",
               ""
            )
            .split("<br>")

         val comunas = data[0]
         val distrito = data[1]
         val region = data[2]
         val periodo = data[3]
         val partido = data[4]
         val bancada = data[5]

         return DiputadoDetailNetworkModel(
            nombre = name,
            region = region,
            comunas = comunas,
            distrito = distrito,
            partido = partido,
            periodo = periodo,
            bancada = bancada,
            picture = picture
         )
      } catch (e: Exception) {
         return DiputadoDetailNetworkModel(
            nombre = "${e.message}",
            region = "",
            comunas = "",
            distrito = "",
            partido = "",
            bancada = "",
            picture = ""
         )
      }
   }
}