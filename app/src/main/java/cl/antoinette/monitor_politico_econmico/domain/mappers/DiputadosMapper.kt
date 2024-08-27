package cl.antoinette.monitor_politico_econmico.domain.mappers

import cl.antoinette.monitor_politico_econmico.data.database.entities.DiputadoEntity
import cl.antoinette.monitor_politico_econmico.data.network.model.DiputadoNetworkModel
import cl.antoinette.monitor_politico_econmico.domain.pojos.Diputado

/* mapping from entity to pojo ni domain*/
fun DiputadoEntity.toDomain() = Diputado(
   idDiputadoActual = id,
   nombre = nombre,
   apellido = apellido,
   distrito = distrito,
   partido = partido,
   paginaWeb = paginaWeb,
   mail = mail,
   picture = picture,
)

fun DiputadoNetworkModel.toDomain() =  Diputado(
   nombre = nombre,
   apellido = apellido,
   distrito = distrito,
   partido = partido,
   paginaWeb = paginaWeb,
   mail = mail,
   picture = picture,
)
fun DiputadoNetworkModel.toEntity() =  DiputadoEntity(
   nombre = nombre,
   apellido = apellido,
   distrito = distrito,
   partido = partido,
   paginaWeb = paginaWeb,
   mail = mail,
   picture = picture,
)

