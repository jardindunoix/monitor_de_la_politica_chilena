package cl.antoinette.monitor_politico_econmico.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.TABLE_DIPUTADOS_DETAIL

@Entity(
   TABLE_DIPUTADOS_DETAIL,
   foreignKeys = [ForeignKey(
      entity = DiputadoEntity::class,
      parentColumns = ["id"],
      childColumns = ["diputado_id"],
      onDelete = ForeignKey.CASCADE,
      onUpdate = ForeignKey.CASCADE
   )]
)
data class DiputadoDetailEntity(
   @ColumnInfo("id")
   @PrimaryKey(autoGenerate = true)
   val id: Int = 0,

   @ColumnInfo("diputado_id")
   val diputadoId: String = "",

   @ColumnInfo("nombre")
   val nombre: String,

   @ColumnInfo("region")
   val region: String,

   @ColumnInfo("comunas")
   val comunas: String,

   @ColumnInfo("distrito")
   val distrito: String,

   @ColumnInfo("partido")
   val partido: String,

   @ColumnInfo("periodo")
   val periodo: String,

   @ColumnInfo("bancada")
   val bancada: String,

   @ColumnInfo("picture")
   val picture: String
)