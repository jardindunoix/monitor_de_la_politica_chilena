package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("diputados")
data class DiputadoEntity(
   @PrimaryKey(autoGenerate = true)
   var id: Int = 0,
   var idDiputadoActual: Int = 0,
   var nombre: String = "NOMBRE del CHORRO",
   var apellido: String = "",
   var distrito: String = "",
   var partido: String = "",
   var paginaWeb: String = "WEB PAGE",
   var mail: String = "",
   var picture: String = ""
)
