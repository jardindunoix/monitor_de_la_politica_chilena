package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain.DiputadosUseCase
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain.objects.DiputadoObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiputadosViewModel
@Inject constructor(
    private val diputadosUseCase: DiputadosUseCase
) : ViewModel() {

    var diputadosActualesList = MutableLiveData<MutableList<DiputadoObject>>(mutableListOf())

    init {
        CoroutineScope(Dispatchers.IO).launch {
            getDiputadosActualesList()
        }
    }

    private suspend fun getDiputadosActualesList() {
        diputadosActualesList.postValue(diputadosUseCase.getDiputadosDocument())
    }

}
