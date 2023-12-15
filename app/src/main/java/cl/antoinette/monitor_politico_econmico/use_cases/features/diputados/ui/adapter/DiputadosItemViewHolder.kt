package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.ui.adapter

import cl.antoinette.monitor_politico_econmico.databinding.ItemDiputadosActualesBinding
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain.model.DiputadoObject
import com.squareup.picasso.Picasso

class DiputadosItemViewHolder (private val binding: ItemDiputadosActualesBinding):
    DiputadosBaseViewHolder<DiputadoObject>(binding.root) {

    override fun bind(item: DiputadoObject) = with(binding) {
        Picasso.get().load(item.picture).into(imageViewDiputadoActual)
        textViewNombreDiputadoActual.text = item.nombre
    }
}