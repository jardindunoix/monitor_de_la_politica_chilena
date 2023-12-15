package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.antoinette.monitor_politico_econmico.databinding.ItemDiputadosActualesBinding
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain.model.DiputadoObject

class DiputadosAdapter(
	private var list:MutableList<DiputadoObject> = mutableListOf(),
	private val context:Context
):
	RecyclerView.Adapter<DiputadosBaseViewHolder<*>>() {

	override fun onCreateViewHolder(parent:ViewGroup, viewType:Int): DiputadosBaseViewHolder<*> {
		val binding =
			ItemDiputadosActualesBinding.inflate(LayoutInflater.from(context), parent, false)

		return DiputadosItemViewHolder(binding)
	}

	override fun onBindViewHolder(holder: DiputadosBaseViewHolder<*>, position:Int) {
		when (holder) {
			is DiputadosItemViewHolder -> holder.bind(list[position])
		}
	}

	override fun getItemCount():Int {
		return list.size
	}

	fun setItemInTheView(diputadosActuales:MutableList<DiputadoObject>?) {
		if (diputadosActuales != null) {
			this.list = diputadosActuales
			notifyDataSetChanged()
		}
	}

}