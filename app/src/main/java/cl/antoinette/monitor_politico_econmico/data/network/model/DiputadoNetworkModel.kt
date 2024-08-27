package cl.antoinette.monitor_politico_econmico.data.network.model

import com.google.gson.annotations.SerializedName

data class DiputadoNetworkModel(
   @SerializedName("id")
   var id: Int = 0,
   @SerializedName("id_diputado_actual")
   var idDiputadoActual: Int = 0,
   @SerializedName("nombre")
   var nombre: String = "NOMBRE del CHORRO",
   @SerializedName("apellido")
   var apellido: String = "",
   @SerializedName("distrito")
   var distrito: String = "",
   @SerializedName("partido")
   var partido: String = "",
   @SerializedName("pagina_web")
   var paginaWeb: String = "WEB PAGE",
   @SerializedName("mail")
   var mail: String = "",
   @SerializedName("picture")
   var picture: String = ""
)
