package cl.antoinette.monitor_politico_econmico.data

import cl.antoinette.monitor_politico_econmico.data.database.room.DiputadosDao
import cl.antoinette.monitor_politico_econmico.data.database.room.DiputadosDetailDao
import cl.antoinette.monitor_politico_econmico.data.mappers.entityDetailToDomain
import cl.antoinette.monitor_politico_econmico.data.mappers.entityToDomain
import cl.antoinette.monitor_politico_econmico.data.mappers.networkDetailToDomain
import cl.antoinette.monitor_politico_econmico.data.mappers.networkDetailToEntity
import cl.antoinette.monitor_politico_econmico.data.mappers.networkToDomain
import cl.antoinette.monitor_politico_econmico.data.mappers.networkToEntity
import cl.antoinette.monitor_politico_econmico.data.network.DiputadoDetailWebScrapProvider
import cl.antoinette.monitor_politico_econmico.data.network.DiputadosWebScrapProvider
import cl.antoinette.monitor_politico_econmico.domain.pojos.Diputado
import cl.antoinette.monitor_politico_econmico.domain.pojos.DiputadoDetail
import javax.inject.Inject

class DiputadosRepository @Inject constructor(
   private val dao: DiputadosDao,
   private val daoDetail: DiputadosDetailDao,
   private val diputadosWebscrapProvider: DiputadosWebScrapProvider,
   private val diputadoDetailWebscrapProvider: DiputadoDetailWebScrapProvider
) {

   suspend fun getDiputadosFromWebScrap(): List<Diputado> {
      val response = diputadosWebscrapProvider.getDiputadosActuales()
      dao.insertAllDiputadosEntity(response.map {
         it!!.networkToEntity()
      })
      return response.map {
         it!!.networkToDomain()
      }
   }

   suspend fun getDiputadosFromDatabase(): List<Diputado> {
      return dao
         .getAllDiputados()
         .map { it.entityToDomain() }
   }

   suspend fun clearAllTables() {
      dao.clearDiputadosTable()
      daoDetail.clearDiputadosDetail()
   }

   suspend fun getDiputadoDetail(
      id: String,
      url: String
   ): DiputadoDetail {


      return daoDetail
         .getDiputadoDetail(id)
         .let {
            it
               ?.entityDetailToDomain()
               .let {
                  val diputadoWS = diputadoDetailWebscrapProvider.getDiputadoDetailNetwork(url)
                  daoDetail.insertDiputadoDetail(diputadoWS.networkDetailToEntity())
                  diputadoWS.networkDetailToDomain()
               }
         }

   }
}