package cl.antoinette.monitor_politico_econmico.data

import cl.antoinette.monitor_politico_econmico.data.database.entities.DiputadoEntity
import cl.antoinette.monitor_politico_econmico.data.database.room.DiputadosDao
import cl.antoinette.monitor_politico_econmico.data.network.DiputadosWebScrapCallProvider
import cl.antoinette.monitor_politico_econmico.domain.mappers.toDomain
import cl.antoinette.monitor_politico_econmico.domain.mappers.toEntity
import cl.antoinette.monitor_politico_econmico.domain.pojos.Diputado
import javax.inject.Inject

class DiputadosRepository @Inject constructor(
   private val dao: DiputadosDao,
   private val diputadosWebscrapProvider: DiputadosWebScrapCallProvider
) {

   suspend fun getAllDiputadosFromDatabase(): List<Diputado> {
      val response: List<DiputadoEntity> = dao.getAllDiputados()
      return response.map { it.toDomain() }
   }

   suspend fun getDiputadosFromWebScrap(): List<Diputado> {
      val response = diputadosWebscrapProvider.getDiputadosActuales()
      dao.insertDiputadosAll(response.map { it!!.toEntity() })
      return response.map { it!!.toDomain() }
   }

   suspend fun getDiputadosFromDatabase(): List<Diputado> {
      return diputadosWebscrapProvider
         .getDiputadosActuales()
         .map { it!!.toDomain() }
   }

   suspend fun clearTables() {
      dao.clearDiputadosTable()
   }
}