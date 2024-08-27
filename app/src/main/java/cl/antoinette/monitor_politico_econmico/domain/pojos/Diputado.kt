package cl.antoinette.monitor_politico_econmico.domain.pojos

data class Diputado(
   val idDiputadoActual: Int = 0,
   val nombre: String = "NOMBRE del CHORRO",
   var apellido: String = "",
   var distrito: String = "",
   val partido: String = "",
   val paginaWeb: String = "WEB PAGE",
   val mail: String = "",
   val picture: String = ""
)
