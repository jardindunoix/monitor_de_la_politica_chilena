package cl.antoinette.monitor_politico_econmico.data

import android.util.Log
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
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.TAG
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

      val diputadoDB = daoDetail.getDiputadoDetail(id)

      Log.d(
         TAG,
         "getDiputadoDetail: $diputadoDB"
      )

      return diputadoDB.let {
         it
            ?.entityDetailToDomain()
            .let {
               val diputadoWS = diputadoDetailWebscrapProvider.getDiputadoDetailNetwork(url)
               daoDetail.insertDiputadoDetail(diputadoWS.networkDetailToEntity())
               diputadoWS.networkDetailToDomain()
            }
      }

//      return if (diputadoDB == null) {
//      } else {
//         diputadoDB.entityDetailToDomain()
//      }

   }
}