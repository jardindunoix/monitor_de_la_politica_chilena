package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.antoinette.monitor_politico_econmico.databinding.ItemDiputadosActualesBinding
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain.model.DiputadoModel

class DiputadosAdapter(
    private var list: List<DiputadoModel> = mutableListOf(),
    private val onItemSelected: () -> Unit
) :
    RecyclerView.Adapter<DiputadosBaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiputadosBaseViewHolder<*> {
        val binding = ItemDiputadosActualesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DiputadosItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DiputadosBaseViewHolder<*>, position: Int) {
        when (holder) {
            is DiputadosItemViewHolder -> holder.bind(list[position], onItemSelected)
        }
    }

    override fun getItemCount() = list.size

    fun setItemInTheView(diputadosActuales: List<DiputadoModel>?) {
        if (diputadosActuales != null) {
            this.list = diputadosActuales
            notifyDataSetChanged()
        }
    }

}