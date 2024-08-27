package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.mappers

import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data.database.entities.DiputadoEntity
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain.pojos.Diputado


fun DiputadoEntity.toDomain() = Diputado(
   idDiputadoActual,
   nombre,
   apellido,
   distrito,
   partido,
   paginaWeb,
   mail,
   picture,
)