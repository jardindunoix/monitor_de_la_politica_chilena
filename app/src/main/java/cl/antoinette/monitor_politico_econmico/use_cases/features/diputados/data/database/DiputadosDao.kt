package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data.database.entities.DiputadoEntity

@Dao
interface DiputadosDao {

   /* suspend permite liberar el hilo principal y se puede usar en un viewmodel*//*pero si se quiere usar el livedata/flows/RxJava/Waba?? no se pone en suspend*/
   @Query("SELECT * FROM diputados")
   fun getAllDiputados(): LiveData<List<DiputadoEntity>>

   @Query("SELECT * FROM diputados WHERE id = :id")
   suspend fun getDiputado(id: Int): DiputadoEntity

   @Update
   suspend fun updateDiputado(diputado: DiputadoEntity)

   @Delete
   suspend fun deleteDiputado(diputado: DiputadoEntity)

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertDiputados(diputados: List<DiputadoEntity>)

   @Insert
   suspend fun insertDiputado(diputado: DiputadoEntity)
}