package cl.antoinette.monitor_politico_econmico.domain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import cl.antoinette.monitor_politico_econmico.data.DiputadosRepository
import cl.antoinette.monitor_politico_econmico.data.network.DiputadosWebScrapCallProvider
import cl.antoinette.monitor_politico_econmico.data.network.model.DiputadoNetworkModel
import cl.antoinette.monitor_politico_econmico.domain.pojos.Diputado
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.BASE_URL_DIP_ACT
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.DIPUTADOS_DIP_ACT
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.TAG
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.util.stream.Collectors
import javax.inject.Inject

class DiputadosUseCase @Inject constructor(
   private val repository: DiputadosRepository
) {
   private var diputadosList = MutableLiveData<MutableList<DiputadoNetworkModel>?>(mutableListOf())

   init {
      CoroutineScope(Dispatchers.IO).launch {
         getDiputadosDocument()
      }
   }

   suspend fun getDiputadosDocument(): MutableList<DiputadoNetworkModel>? {
      try {
         val document: Document = DiputadosWebScrapCallProvider.getDiputadosActuales()
         val articleElement: Elements = document.select("article.grid-2")
         val h4Elements = articleElement
            .select("h4")
            .eachText()
         val nameList = h4Elements
            .stream()
            .collect(Collectors.toList())
         val webpage = articleElement
            .select("a")
            .eachAttr("href")
            .stream()
            .collect(Collectors.toList())
         val imagesList = articleElement
            .select("img")
            .eachAttr("src")
            .stream()
            .collect(Collectors.toList())
         var countAttr = 0

         if (webpage.size / 3 == nameList.size) {
            val oldValueOne = "Sr. "
            val oldValueTwo = "Sra. "
            val newValue = ""

            for ((i, f) in imagesList.withIndex()) {
               diputadosList.value?.add(
                  DiputadoNetworkModel(
                     nombre = nameList[i]
                        .replace(oldValueOne, newValue)
                        .replace(oldValueTwo, newValue), paginaWeb = "${BASE_URL_DIP_ACT}${DIPUTADOS_DIP_ACT}${webpage[countAttr]}", picture = "${BASE_URL_DIP_ACT}${f}"
                  )
               )
               countAttr += 3
            }
         }
         Log.d(TAG, "getDiputadosDocument: ${diputadosList.value}")
         return diputadosList.value
      } catch (e: Exception) {
         Log.d(TAG, "getDiputadosDocument exception: ${e.localizedMessage}")
         return mutableListOf<DiputadoNetworkModel>()
      }
   }


   suspend operator fun invoke(): List<Diputado> {
      return repository.getAllDiputadosFromDatabase()
   }


}

