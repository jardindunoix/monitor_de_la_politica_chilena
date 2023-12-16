package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados

import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain.model.DiputadoObject

interface DiputadosRepository {

    suspend fun getDiputadosList(sign: String): List<DiputadoObject>?
}