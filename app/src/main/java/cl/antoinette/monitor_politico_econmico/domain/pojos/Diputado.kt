package cl.antoinette.monitor_politico_econmico.domain.pojos

import androidx.annotation.Keep

@Keep
data class Diputado(
   val idDiputadoActual: String = "",
   val nombre: String = "",
   val apellido: String = "",
   val distrito: String = "",
   val partido: String = "",
   val paginaWeb: String = "",
   val mail: String = "",
   val picture: String = ""
)
