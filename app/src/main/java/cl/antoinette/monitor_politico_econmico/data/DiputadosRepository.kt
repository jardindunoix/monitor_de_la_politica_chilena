package cl.antoinette.monitor_politico_econmico.data

import android.util.Log
import cl.antoinette.monitor_politico_econmico.data.database.entities.DiputadoEntity
import cl.antoinette.monitor_politico_econmico.data.database.room.DiputadosDao
import cl.antoinette.monitor_politico_econmico.data.network.DiputadoDetailWebScrapCallProvider
import cl.antoinette.monitor_politico_econmico.data.network.DiputadosWebScrapCallProvider
import cl.antoinette.monitor_politico_econmico.domain.mappers.toDomain
import cl.antoinette.monitor_politico_econmico.domain.mappers.toEntity
import cl.antoinette.monitor_politico_econmico.domain.pojos.Diputado
import cl.antoinette.monitor_politico_econmico.domain.pojos.DiputadoDetail
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.TAG
import javax.inject.Inject

class DiputadosRepository @Inject constructor(
   private val dao: DiputadosDao,
   private val diputadosWebscrapProvider: DiputadosWebScrapCallProvider,
   private val diputadoDetailWebscrapProvider: DiputadoDetailWebScrapCallProvider
) {

   suspend fun getAllDiputadosFromDatabase(): List<Diputado> {
      val response: List<DiputadoEntity> = dao.getAllDiputados()
      return response.map { it.toDomain() }
   }

   suspend fun getDiputadosFromWebScrap(): List<Diputado> {
      val response = diputadosWebscrapProvider.getDiputadosActuales()
      dao.insertDiputadosAll(response.map {
         it!!.toEntity()
      })
      return response.map {
         it!!.toDomain()
      }
   }

   suspend fun getDiputadosFromDatabase(): List<Diputado> {
      return dao
         .getAllDiputados()
         .map { it.toDomain() }
   }

   suspend fun clearTables() {
      dao.clearDiputadosTable()
      dao.clearDiputadosDetailTable()
   }

   suspend fun getDiputadoDetail(
      id: String,
      url: String
   ): DiputadoDetail {

      val diputadoDB = dao.getDiputadoDetailEntity(id)

      Log.d(
         TAG,
         "DETAIL: $diputadoDB "
      )

      return if (diputadoDB == null) {
         val diputadoWS = diputadoDetailWebscrapProvider.getDiputadoDetailNetwork(url)

//         Log.d(
//            TAG,
//            "DETAIL WEBSCRAP: $diputadoWS "
//         )

         diputadoWS.toDomain()
      } else {

         //         Log.d(
//            TAG,
//            "DETAIL DATABASE: "
//         )

         diputadoDB.toDomain()
      }

   }
}