package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain.model

data class DiputadoModel(
    var idDiputadoActual: Int = 0,
    var nombre: String = "NOMBRE del CHORRO",
    var apellido: String = "",
    var distrito: String = "",
    var partido: String = "",
    var paginaWeb: String = "WEB PAGE",
    var mail: String = "",
    var picture: String = ""
)
