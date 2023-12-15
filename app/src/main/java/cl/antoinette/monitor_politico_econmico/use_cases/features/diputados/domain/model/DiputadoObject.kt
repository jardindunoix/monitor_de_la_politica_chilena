package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain.model

data class DiputadoObject(
    var idDiputadoActual: Int = 0,
    var nombre: String = "NOMBRE CHORRO",
    var apellido: String = "",
    var distrito: String = "",
    var partido: String = "",
    var paginaWeb: String = "WEB PAGE",
    var mail: String = "",
    var picture: String = ""
)
