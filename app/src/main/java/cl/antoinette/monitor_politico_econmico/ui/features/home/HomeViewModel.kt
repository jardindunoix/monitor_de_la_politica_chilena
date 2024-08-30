package cl.antoinette.monitor_politico_econmico.ui.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import cl.antoinette.monitor_politico_econmico.data.ConnectivityRepository
import cl.antoinette.monitor_politico_econmico.domain.DiputadosUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
   connectivityRepository: ConnectivityRepository,
   private val diputadosUseCase: DiputadosUseCases,
) : ViewModel() {

   val isOnline = connectivityRepository.isConnected.asLiveData()

   private val _spinner = MutableLiveData<Boolean>(false)
   var spinner: LiveData<Boolean> = _spinner

   suspend fun clearData(badgeState: Boolean) {
      _spinner.value = diputadosUseCase.clearData(badgeState)
   }

}