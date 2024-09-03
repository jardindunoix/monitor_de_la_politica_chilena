package cl.antoinette.monitor_politico_econmico.domain.pojos

data class DiputadoDetail(
   val idDiputadoDetail: Int = -1,
   val nombre: String = "",
   var region: String = "",
   var comunas: String = "",
   var distrito: String = "",
   val partido: String = "",
   val periodo: String = "",
   val bancada: String = "",
   val picture: String = ""
)
