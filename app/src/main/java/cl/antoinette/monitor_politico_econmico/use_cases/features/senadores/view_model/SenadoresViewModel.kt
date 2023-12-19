package cl.antoinette.monitor_politico_econmico.use_cases.features.senadores.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain.objects.DiputadoObject
import cl.antoinette.monitor_politico_econmico.use_cases.features.senadores.domain.SenadoresUseCase
import cl.antoinette.monitor_politico_econmico.use_cases.features.senadores.domain.objects.SenadorObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SenadoresViewModel
@Inject constructor(
    private val senadoresUseCase: SenadoresUseCase
) : ViewModel() {

    var senadoresList = MutableLiveData<MutableList<SenadorObject>?>(mutableListOf())

    init {
        CoroutineScope(Dispatchers.IO).launch {
            getSenadoresActualesList()
        }
    }

    private suspend fun getSenadoresActualesList() {
        senadoresList.postValue(senadoresUseCase.getSenadoresDocument())
    }

}
