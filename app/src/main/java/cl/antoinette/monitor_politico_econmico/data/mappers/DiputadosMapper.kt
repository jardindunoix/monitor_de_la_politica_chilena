package cl.antoinette.monitor_politico_econmico.data.mappers

import cl.antoinette.monitor_politico_econmico.data.database.entities.DiputadoEntity
import cl.antoinette.monitor_politico_econmico.data.network.model.DiputadoNetworkModel
import cl.antoinette.monitor_politico_econmico.domain.pojos.Diputado

/* mapping from entity to pojo ni domain*/
fun DiputadoEntity.entityToDomain() = Diputado(
   idDiputadoActual = id,
   nombre = nombre,
   apellido = apellido,
   distrito = distrito,
   partido = partido,
   paginaWeb = paginaWeb,
   picture = picture,
)

fun DiputadoNetworkModel.networkToDomain() = Diputado(
   idDiputadoActual = id,
   nombre = nombre,
   apellido = apellido,
   distrito = distrito,
   partido = partido,
   paginaWeb = paginaWeb,
   picture = picture,
)

fun DiputadoNetworkModel.networkToEntity() = DiputadoEntity(
   id = id,
   nombre = nombre,
   apellido = apellido,
   distrito = distrito,
   partido = partido,
   paginaWeb = paginaWeb,
   picture = picture,
)
