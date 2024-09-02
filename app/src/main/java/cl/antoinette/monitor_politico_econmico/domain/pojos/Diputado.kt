package cl.antoinette.monitor_politico_econmico.domain.pojos

data class Diputado(
   val idDiputadoActual: Int = -1,
   val nombre: String = "",
   var apellido: String = "",
   var distrito: String = "",
   val partido: String = "",
   val paginaWeb: String = "",
   val mail: String = "",
   val picture: String = ""
)
