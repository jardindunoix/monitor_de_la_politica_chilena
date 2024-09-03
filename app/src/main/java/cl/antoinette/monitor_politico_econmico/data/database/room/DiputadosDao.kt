package cl.antoinette.monitor_politico_econmico.data.database.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import cl.antoinette.monitor_politico_econmico.data.database.entities.DiputadoEntity
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.TABLE_DIPUTADOS

@Dao
interface DiputadosDao {

   /* suspend permite liberar el hilo principal y se puede usar en un viewmodel*//*pero si se quiere usar el livedata/flows/RxJava/Waba?? no se pone en suspend*/
   @Query("SELECT * FROM diputados")
   suspend fun getAllDiputados(): List<DiputadoEntity>

   @Query("SELECT * FROM diputados WHERE id = :id")
   suspend fun getDiputado(id: Int): DiputadoEntity

   @Update
   suspend fun updateDiputado(diputado: DiputadoEntity)

   @Delete
   suspend fun deleteDiputado(diputado: DiputadoEntity)

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertDiputadosAll(diputados: List<DiputadoEntity>)

   @Insert
   suspend fun insertDiputado(diputado: DiputadoEntity)

   @Query("DELETE FROM $TABLE_DIPUTADOS")
   suspend fun clearDiputadosTable()

//   @Query("UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='$TABLE_DIPUTADOS'")
//   fun resetTable()
}