package cl.antoinette.monitor_politico_econmico.utilities

class StaticUtils {
   companion object {

      /* LOG MESSAGE  */
      const val TAG = "TAG-------->"

      /*database consts*/
      const val DATABASE_VERSION = 9
      const val DATABASE_NAME = "monitor_db"
      const val TABLE_DIPUTADOS = "diputados"
      const val TABLE_DIPUTADOS_DETAIL = "diputados_detail"

      /*constantes diputados actuales*/
      const val BASE_URL_DIP_ACT = "https://www.camara.cl/"
      const val END_POINT_DIP_ACT = "diputados/diputados.aspx#mostrarDiputados"
      const val DIPUTADOS_DIP_ACT = "diputados/"

   }
}