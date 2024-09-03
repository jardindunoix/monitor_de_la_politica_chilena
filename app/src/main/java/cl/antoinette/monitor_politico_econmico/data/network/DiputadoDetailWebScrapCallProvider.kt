package cl.antoinette.monitor_politico_econmico.data.network

import android.util.Log
import cl.antoinette.monitor_politico_econmico.data.network.model.DiputadoDetailNetworkModel
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.TAG
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import javax.inject.Inject

class DiputadoDetailWebScrapCallProvider @Inject constructor() {

   suspend fun getDiputadoDetail(url: String): DiputadoDetailNetworkModel {
      try {
         val jsoup = Jsoup
            .connect(url)
            .get()

         val document: Document = jsoup

         val articleElement: Elements = document.select("section div.auxi div.grid-3 p")
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

         Log.d(
            TAG,
            "WEBSCRAP  $comunas / $distrito /" + "REGION ${data[2]} / PERIODO ${data[3]} / PARTIDO ${data[4]} / BANCADA ${data[5]}"
         )



         return DiputadoDetailNetworkModel(
            nombre = "Diputada María Candelaria Acevedo Sáez",
            region = "Región del Bío Bío",
            comunas = "Hualpén, Hualqui, Coronel, San Pedro de la Paz, Tomé, Concepción, Santa Juana, Talcahuano, Penco, Florida, Chiguayante",
            distrito = "Nº 20",
            partido = "Partido Comunista",
            bancada = "Comité Comunista, Federación Regionalista Verde Social, Acción Humanista e Independientes ",
            picture = "https://www.camara.cl/img.aspx?prmID=GRCL1096"
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