package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.ui.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import cl.antoinette.monitor_politico_econmico.databinding.ItemDiputadosActualesBinding
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.data.network.model.DiputadoNetworkModel
import com.squareup.picasso.Picasso

class DiputadosItemViewHolder(private val binding: ItemDiputadosActualesBinding) :
    DiputadosBaseViewHolder<DiputadoNetworkModel>(binding.root) {

    override fun bind(item: DiputadoNetworkModel, onItemSelected: () -> Unit) = with(binding) {
        Picasso.get().load(item.picture).into(imageViewDiputadoActual)
        textViewNombreDiputadoActual.text = item.nombre

        linearLayoutDiputadosActuales.setOnClickListener {
            startRotationAnimation(textViewNombreDiputadoActual, newLambda = { onItemSelected() })
        }
    }

    private fun startRotationAnimation(view: View, newLambda: () -> Unit) {
        view.animate().apply {
            duration = 600
            interpolator = LinearInterpolator()
            scaleX(1.3f)
            withEndAction { newLambda() }
            start()
        }
    }
}