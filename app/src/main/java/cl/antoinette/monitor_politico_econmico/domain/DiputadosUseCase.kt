package cl.antoinette.monitor_politico_econmico.domain

import cl.antoinette.monitor_politico_econmico.data.DiputadosRepository
import cl.antoinette.monitor_politico_econmico.domain.pojos.Diputado
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DiputadosUseCase @Inject constructor(
   private val repository: DiputadosRepository
) {
//
//   init {
//      CoroutineScope(Dispatchers.IO).launch {
//         repository.getDiputados()
//      }
//   }


   suspend operator fun invoke(): MutableList<Diputado> { //      return repository.getAllDiputadosFromDatabase()
      return repository.getDiputados()
   }


}


