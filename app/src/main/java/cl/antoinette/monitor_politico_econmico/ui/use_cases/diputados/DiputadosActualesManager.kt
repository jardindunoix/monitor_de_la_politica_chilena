package cl.antoinette.monitor_politico_econmico.ui.use_cases.diputados

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DiputadosActualesManager {
	
	var allDiputadosActuales = MutableLiveData<MutableList<DiputadoActualEntity>>(mutableListOf())
	
	init {
		CoroutineScope(Dispatchers.IO).launch {
			try {
				allDiputadosActuales.postValue(getDiputadosActuales())
			} catch (e:Exception) {
				Log.e("ERRORRRRR ---->", e.toString())
			}
		}
	}
	
	private fun getDiputadosActuales():MutableList<DiputadoActualEntity> {
		return DiputadosActualesWebScrapCall.getDiputadosActuales()
	}
}


