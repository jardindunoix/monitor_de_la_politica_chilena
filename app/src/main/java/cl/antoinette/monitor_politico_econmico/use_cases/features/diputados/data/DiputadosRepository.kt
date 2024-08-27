package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data

import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data.database.DiputadosDao
import javax.inject.Inject

class DiputadosRepository @Inject constructor(
   private val dao: DiputadosDao
) {

   suspend fun getAllDiputadosFromDatabase(){

   }
}