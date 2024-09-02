package cl.antoinette.monitor_politico_econmico.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.TABLE_DIPUTADOS

@Entity(TABLE_DIPUTADOS)
data class DiputadoEntity(
   @ColumnInfo("id")
   @PrimaryKey(autoGenerate = true)
   val id: Int = 0,
   @ColumnInfo("nombre")
   val nombre: String,
   @ColumnInfo("apellido")
   val apellido: String,
   @ColumnInfo("distrito")
   val distrito: String,
   @ColumnInfo("partido")
   val partido: String,
   @ColumnInfo("pagina_web")
   val paginaWeb: String,
   @ColumnInfo("mail")
   val mail: String,
   @ColumnInfo("picture")
   val picture: String
)
