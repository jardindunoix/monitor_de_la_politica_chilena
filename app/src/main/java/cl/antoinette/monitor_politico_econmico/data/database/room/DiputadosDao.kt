package cl.antoinette.monitor_politico_econmico.data.database.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import cl.antoinette.monitor_politico_econmico.data.database.entities.DiputadoDetailEntity
import cl.antoinette.monitor_politico_econmico.data.database.entities.DiputadoEntity
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.TABLE_DIPUTADOS
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.TABLE_DIPUTADOS_DETAIL

@Dao
interface DiputadosDao {

   /* suspend permite liberar el hilo principal y se puede usar en un viewmodel*//*pero si se quiere usar el livedata/flows/RxJava/Waba?? no se pone en suspend*/
   @Query("SELECT * FROM $TABLE_DIPUTADOS")
   suspend fun getAllDiputados(): List<DiputadoEntity>

   @Query("SELECT * FROM $TABLE_DIPUTADOS WHERE id = :id")
   suspend fun getDiputadoEntity(id: String): DiputadoEntity

   @Update
   suspend fun updateDiputadoEntity(diputado: DiputadoEntity)

   @Delete
   suspend fun deleteDiputadoEntity(diputado: DiputadoEntity)

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertAllDiputadosEntity(diputados: List<DiputadoEntity>)

   @Query("DELETE FROM $TABLE_DIPUTADOS")
   suspend fun clearDiputadosTable()
}