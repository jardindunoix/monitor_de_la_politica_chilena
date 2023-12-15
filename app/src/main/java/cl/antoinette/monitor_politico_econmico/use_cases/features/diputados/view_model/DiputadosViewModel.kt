package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain.DiputadosManager
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain.objects.DiputadoObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiputadosViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application) {

    var diputadosActualesList = MutableLiveData<MutableList<DiputadoObject>>(mutableListOf())

    init {
        getDiputadosActualesList()
    }

    private fun getDiputadosActualesList() {
        diputadosActualesList = DiputadosManager().allDiputadosActuales
        viewModelScope.launch {
            diputadosActualesList
        }
    }

}