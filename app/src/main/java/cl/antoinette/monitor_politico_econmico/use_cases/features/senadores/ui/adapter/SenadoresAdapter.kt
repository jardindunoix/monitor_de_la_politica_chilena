package cl.antoinette.monitor_politico_econmico.use_cases.features.senadores.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.antoinette.monitor_politico_econmico.databinding.ItemSenadoresActualesBinding
import cl.antoinette.monitor_politico_econmico.use_cases.features.senadores.domain.objects.SenadorObject

class SenadoresAdapter(
    private var list: MutableList<SenadorObject> = mutableListOf(),
    private val onItemSelected: () -> Unit
) :
    RecyclerView.Adapter<SenadoresBaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SenadoresBaseViewHolder<*> {
        val binding =
            ItemSenadoresActualesBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return SenadoresItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SenadoresBaseViewHolder<*>, position: Int) {
        when (holder) {
            is SenadoresItemViewHolder -> holder.bind(list[position], onItemSelected)
        }
    }

    override fun getItemCount() = list.size

    fun setItemInTheView(senadores: MutableList<SenadorObject>?) {
        if (senadores != null) {
            this.list = senadores
            notifyDataSetChanged()
        }
    }

}