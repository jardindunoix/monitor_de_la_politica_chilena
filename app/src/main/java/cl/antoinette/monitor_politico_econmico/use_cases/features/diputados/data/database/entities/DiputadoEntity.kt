package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.TABLE_DIPUTADOS

@Entity(TABLE_DIPUTADOS)
data class DiputadoEntity(
   @PrimaryKey(autoGenerate = true)
   @ColumnInfo("id")
   var id: Int = 0,
   @ColumnInfo("id_diputado_actual")
   var idDiputadoActual: Int = 0,
   @ColumnInfo("nombre")
   var nombre: String = "NOMBRE del CHORRO",
   @ColumnInfo("apellido")
   var apellido: String = "",
   @ColumnInfo("distrito")
   var distrito: String = "",
   @ColumnInfo("partido")
   var partido: String = "",
   @ColumnInfo("pagina_web")
   var paginaWeb: String = "WEB PAGE",
   @ColumnInfo("mail")
   var mail: String = "",
   @ColumnInfo("picture")
   var picture: String = ""
)
