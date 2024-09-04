package cl.antoinette.monitor_politico_econmico.data.mappers

import cl.antoinette.monitor_politico_econmico.data.database.entities.DiputadoDetailEntity
import cl.antoinette.monitor_politico_econmico.data.network.model.DiputadoDetailNetworkModel
import cl.antoinette.monitor_politico_econmico.domain.pojos.DiputadoDetail


fun DiputadoDetailEntity.entityDetailToDomain() = DiputadoDetail(
   idDiputadoDetail = diputadoId,
   nombre = nombre,
   region = region,
   comunas = comunas,
   distrito = distrito,
   partido = partido,
   periodo = periodo,
   bancada = bancada,
   picture = picture,
)

fun DiputadoDetailNetworkModel.networkDetailToDomain() = DiputadoDetail(
   nombre = nombre,
   region = region,
   comunas = comunas,
   distrito = distrito,
   partido = partido,
   periodo = periodo,
   bancada = bancada,
   picture = picture
)

fun DiputadoDetailNetworkModel.networkDetailToEntity() = DiputadoDetailEntity(
//   id = 0,
   diputadoId = id,
   nombre = nombre,
   region = region,
   comunas = comunas,
   distrito = distrito,
   partido = partido,
   periodo = periodo,
   bancada = bancada,
   picture = picture
)

