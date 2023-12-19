package cl.antoinette.monitor_politico_econmico.use_cases.features.senadores.domain.objects

data class SenadorObject(
    var idSenadorActual: Int = 0,
    var nombre: String = "NOMBRE CHORRO",
    var apellido: String = "",
    var distrito: String = "",
    var partido: String = "",
    var paginaWeb: String = "WEB PAGE",
    var mail: String = "",
    var picture: String = ""
)
