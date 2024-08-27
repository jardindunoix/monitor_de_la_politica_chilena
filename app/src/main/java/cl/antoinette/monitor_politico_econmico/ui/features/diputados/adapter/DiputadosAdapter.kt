package cl.antoinette.monitor_politico_econmico.ui.features.diputados.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.antoinette.monitor_politico_econmico.databinding.ItemDiputadosActualesBinding
import cl.antoinette.monitor_politico_econmico.data.network.model.DiputadoNetworkModel

class DiputadosAdapter(
    private var list: List<DiputadoNetworkModel> = mutableListOf(),
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

    fun setItemInTheView(diputadosActuales: List<DiputadoNetworkModel>?) {
        if (diputadosActuales != null) {
            this.list = diputadosActuales
            notifyDataSetChanged()
        }
    }

}