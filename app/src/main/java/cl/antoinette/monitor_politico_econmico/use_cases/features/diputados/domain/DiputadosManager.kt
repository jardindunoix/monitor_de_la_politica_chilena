package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data.DiputadosWebScrapCallProvider
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain.objects.DiputadoObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DiputadosManager {
    var allDiputadosActuales = MutableLiveData<MutableList<DiputadoObject>>(mutableListOf())

    init {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                allDiputadosActuales.postValue(getDiputadosActuales())
            } catch (e:Exception) {
                Log.e("ERRORRRRR ---->", e.toString())
            }
        }
    }

    private fun getDiputadosActuales():MutableList<DiputadoObject> {
        return DiputadosWebScrapCallProvider.getDiputadosActuales()
    }
}


