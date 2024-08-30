package cl.antoinette.monitor_politico_econmico.domain

import cl.antoinette.monitor_politico_econmico.data.DiputadosRepository
import cl.antoinette.monitor_politico_econmico.domain.pojos.Diputado
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DiputadosUseCases @Inject constructor(
   private val repository: DiputadosRepository
) {

//   private val _spinnerState = MutableFlow<Boolean>()
//   var spinnerState: StateFlow<Boolean> = _spinnerState

   val spinnerState = flow<Boolean> {

   }

   suspend fun clearData() {
      delay(1500)
   }

   suspend operator fun invoke(): List<Diputado> {
      val response = repository.getAllDiputadosFromDatabase()
      return if (response.isEmpty()) {
         repository.getDiputadosFromWebScrap()
      } else {
         repository.getDiputadosFromDatabase()
      }
   }


}


