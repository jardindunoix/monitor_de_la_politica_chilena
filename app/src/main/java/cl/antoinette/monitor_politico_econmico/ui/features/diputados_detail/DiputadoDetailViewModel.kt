package cl.antoinette.monitor_politico_econmico.ui.features.diputados_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.antoinette.monitor_politico_econmico.data.ConnectivityRepository
import cl.antoinette.monitor_politico_econmico.domain.DiputadosUseCases
import cl.antoinette.monitor_politico_econmico.domain.pojos.Diputado
import cl.antoinette.monitor_politico_econmico.domain.pojos.DiputadoDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DiputadoDetailViewModel @Inject constructor(
   private val diputadosUseCase: DiputadosUseCases,
   connectivityRepository: ConnectivityRepository
) : ViewModel() {


   suspend fun getDiputadosActualesList(url: String): DiputadoDetail {
      return diputadosUseCase.getDiputadoDetail(url)
   }
}