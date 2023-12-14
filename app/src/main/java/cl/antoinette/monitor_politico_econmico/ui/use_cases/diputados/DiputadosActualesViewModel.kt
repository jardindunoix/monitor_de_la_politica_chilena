package cl.antoinette.monitor_politico_econmico.ui.use_cases.diputados

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DiputadosActualesViewModel(application: Application) : AndroidViewModel(application) {

    var diputadosActualesList = MutableLiveData<MutableList<DiputadoActualEntity>>(mutableListOf())

    init {
        getDiputadosActualesList()
    }

    private fun getDiputadosActualesList() {
        diputadosActualesList = DiputadosActualesManager().allDiputadosActuales
        viewModelScope.launch {
            diputadosActualesList
        }
    }

}
