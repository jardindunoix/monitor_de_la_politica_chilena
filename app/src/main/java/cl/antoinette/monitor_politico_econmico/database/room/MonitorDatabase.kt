package cl.antoinette.monitor_politico_econmico.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data.database.DiputadosDao
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data.database.entities.DiputadoEntity
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.DATABASE_VERSION

@Database(
   version = DATABASE_VERSION,
   entities = [
      DiputadoEntity::class
   ]
)
abstract class MonitorDatabase : RoomDatabase() {

   abstract fun diputadosDao(): DiputadosDao

}