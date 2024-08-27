package cl.antoinette.monitor_politico_econmico.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data.database.DiputadosDao
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data.database.entities.DiputadoEntity

@Database(
   version = 1,
   entities = [
      DiputadoEntity::class
   ]
)
abstract class MonitorDatabase : RoomDatabase() {

   abstract fun diputadosDao(): DiputadosDao

}