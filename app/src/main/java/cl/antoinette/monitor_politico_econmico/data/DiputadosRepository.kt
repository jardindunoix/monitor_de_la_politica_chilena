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
   }

   suspend fun getDiputadoDetail(
      id: String,
      url: String
   ): DiputadoDetail {

      val diputadoDB = dao.getDiputadoDetailEntity(id)

      return if (diputadoDB?.nombre == null) {
         Log.d(
            TAG,
            "DETAIL WEBSCRAP: "
         )
         val diputadoWS = diputadoDetailWebscrapProvider.getDiputadoDetailNetwork(url)
         dao.insertDiputadoEntity(diputadoWS.toEntity())
         diputadoWS.toDomain()
      } else {
         Log.d(
            TAG,
            "DETAIL DATABASE: "
         )
         diputadoDB.toDomain()
      }

   }
}