package cl.antoinette.monitor_politico_econmico.domain.mappers

import cl.antoinette.monitor_politico_econmico.data.database.entities.DiputadoEntity
import cl.antoinette.monitor_politico_econmico.data.database.entities.DiputadosDetailEntity
import cl.antoinette.monitor_politico_econmico.data.network.model.DiputadoDetailNetworkModel
import cl.antoinette.monitor_politico_econmico.data.network.model.DiputadoNetworkModel
import cl.antoinette.monitor_politico_econmico.domain.pojos.Diputado
import cl.antoinette.monitor_politico_econmico.domain.pojos.DiputadoDetail

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

fun DiputadoNetworkModel.toDomain() = Diputado(
   idDiputadoActual = id,
   nombre = nombre,
   apellido = apellido,
   distrito = distrito,
   partido = partido,
   paginaWeb = paginaWeb,
   mail = mail,
   picture = picture,
)

fun DiputadoDetailNetworkModel.toDomain() = DiputadoDetail(
   nombre = nombre,
   region = region,
   comunas = comunas,
   distrito = distrito,
   partido = partido,
   bancada = bancada,
   picture = picture
)

fun DiputadoDetailNetworkModel.toEntity() = DiputadosDetailEntity(
   nombre = nombre,
   region = region,
   comunas = comunas,
   distrito = distrito,
   partido = partido,
   bancada = bancada,
   picture = picture
)

fun DiputadoNetworkModel.toEntity() = DiputadoEntity(
   id = id,
   nombre = nombre,
   apellido = apellido,
   distrito = distrito,
   partido = partido,
   paginaWeb = paginaWeb,
   mail = mail,
   picture = picture,
)

