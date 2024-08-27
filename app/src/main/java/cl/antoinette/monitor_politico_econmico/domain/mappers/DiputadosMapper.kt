package cl.antoinette.monitor_politico_econmico.domain.mappers

import cl.antoinette.monitor_politico_econmico.data.database.entities.DiputadoEntity
import cl.antoinette.monitor_politico_econmico.domain.pojos.Diputado


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