package cl.antoinette.monitor_politico_econmico.utilities

class StaticUtils {
   companion object {

      /* LOG MESSAGE  */
      const val TAG = "TAG-------->"

      /*database consts*/
      const val DATABASE_VERSION = 1
      const val DATABASE_NAME = "monitor_db"
      const val TABLE_DIPUTADOS = "diputados"

      /*Constantes enteras*/
      const val YOYO_DURATION = 500L

      /*constantes diputados actuales*/ //	https://www.camara.cl/diputados/diputados.aspx#mostrarDiputados
      const val BASE_URL_DIP_ACT = "https://www.camara.cl/"
      const val END_POINT_DIP_ACT = "diputados/diputados.aspx#mostrarDiputados"
      const val DIPUTADOS_DIP_ACT = "diputados/"

   }
}