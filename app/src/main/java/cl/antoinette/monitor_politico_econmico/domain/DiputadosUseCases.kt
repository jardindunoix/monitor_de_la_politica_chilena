package cl.antoinette.monitor_politico_econmico.domain

import android.util.Log
import cl.antoinette.monitor_politico_econmico.data.DiputadosRepository
import cl.antoinette.monitor_politico_econmico.domain.pojos.Diputado
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.TAG
import kotlinx.coroutines.delay
import javax.inject.Inject

class DiputadosUseCases @Inject constructor(
   private val repository: DiputadosRepository
) {

   suspend operator fun invoke(): List<Diputado> {
      val response = repository.getAllDiputadosFromDatabase()
      return if (response.isEmpty()) {
         repository.getDiputadosFromWebScrap()
      } else {
         repository.getDiputadosFromDatabase()
      }
   }

   suspend fun clearData(badgeState: Boolean): Boolean {
      return !badgeState
   }

}


