package cl.antoinette.monitor_politico_econmico.domain.pojos

data class Diputado(
   var idDiputadoActual: Int = 0,
   var nombre: String = "NOMBRE del CHORRO",
   var apellido: String = "",
   var distrito: String = "",
   var partido: String = "",
   var paginaWeb: String = "WEB PAGE",
   var mail: String = "",
   var picture: String = ""
)
