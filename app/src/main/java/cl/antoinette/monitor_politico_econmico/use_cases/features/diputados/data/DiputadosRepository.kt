package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data

import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data.database.DiputadosDao
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data.database.entities.DiputadoEntity
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain.pojos.Diputado
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.mappers.toDomain
import javax.inject.Inject

class DiputadosRepository @Inject constructor(
   private val dao: DiputadosDao
) {

   suspend fun getAllDiputadosFromDatabase(): List<Diputado> {
      val response: List<DiputadoEntity> = dao.getAllDiputados()
      return response.map { it.toDomain() }
   }

}