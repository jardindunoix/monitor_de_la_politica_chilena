package cl.antoinette.monitor_politico_econmico.data.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.antoinette.monitor_politico_econmico.data.database.entities.DiputadoEntity
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