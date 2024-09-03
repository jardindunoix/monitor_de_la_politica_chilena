package cl.antoinette.monitor_politico_econmico.data.network.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class DiputadoDetailNetworkModel(

   @SerializedName("nombre")
   val nombre: String = "",

   @ColumnInfo("region")
   val region: String = "",

   @SerializedName("comunas")
   val comunas: String = "",

   @SerializedName("distrito")
   val distrito: String = "",

   @SerializedName("partido")
   val partido: String = "",

   @SerializedName("periodo")
   val periodo: String = "",

   @SerializedName("bancada")
   val bancada: String = "",

   @SerializedName("picture")
   val picture: String = ""
)
