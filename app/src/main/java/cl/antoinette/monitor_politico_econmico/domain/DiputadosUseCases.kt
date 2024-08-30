package cl.antoinette.monitor_politico_econmico.domain

import android.util.Log
import cl.antoinette.monitor_politico_econmico.data.DiputadosRepository
import cl.antoinette.monitor_politico_econmico.domain.pojos.Diputado
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.TAG
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DiputadosUseCases @Inject constructor(
   private val repository: DiputadosRepository
) {

   suspend fun clearData() {
      repository.clearTables()
      delay(800)
   }

   suspend operator fun invoke(): List<Diputado> {
      val response = repository.getAllDiputadosFromDatabase()
      return if (response.isEmpty()) {
         Log.d(TAG, "invoke: ENTRA EN WEBSCRAP")
         repository.getDiputadosFromWebScrap()
      } else {
         Log.d(TAG, "invoke: ENTRA EN DATABASE")
         repository.getDiputadosFromDatabase()
      }
   }


}


