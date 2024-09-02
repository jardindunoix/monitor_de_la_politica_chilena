package cl.antoinette.monitor_politico_econmico.data.network.model

import com.google.gson.annotations.SerializedName

data class DiputadoNetworkModel(

   @SerializedName("nombre")
   var nombre: String = "NOMBRE del CHORRO",
   @SerializedName("apellido")
   var apellido: String = "DEFAULT LAST NAME",
   @SerializedName("distrito")
   var distrito: String = "DISTRICT",
   @SerializedName("partido")
   var partido: String = "PARTIDO",
   @SerializedName("pagina_web")
   var paginaWeb: String = "WEB PAGE",
   @SerializedName("mail")
   var mail: String = "default@email.com",
   @SerializedName("picture")
   var picture: String = "chorro's picture"
)
