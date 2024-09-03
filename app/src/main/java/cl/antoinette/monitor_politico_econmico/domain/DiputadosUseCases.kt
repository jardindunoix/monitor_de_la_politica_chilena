package cl.antoinette.monitor_politico_econmico.domain

import cl.antoinette.monitor_politico_econmico.data.DiputadosRepository
import cl.antoinette.monitor_politico_econmico.domain.pojos.Diputado
import cl.antoinette.monitor_politico_econmico.domain.pojos.DiputadoDetail
import kotlinx.coroutines.delay
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
         repository.getDiputadosFromWebScrap()
      } else {
         repository.getDiputadosFromDatabase()
      }
   }

   suspend fun getDiputadoDetail(id: String,url: String): DiputadoDetail {
      return repository.getDiputadoDetail(id, url)
   }

}


