package cl.antoinette.monitor_politico_econmico.use_cases.features.senadores.ui.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import cl.antoinette.monitor_politico_econmico.databinding.ItemDiputadosActualesBinding
import cl.antoinette.monitor_politico_econmico.databinding.ItemSenadoresActualesBinding
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain.objects.DiputadoObject
import cl.antoinette.monitor_politico_econmico.use_cases.features.senadores.domain.objects.SenadorObject
import com.squareup.picasso.Picasso

class SenadoresItemViewHolder(private val binding: ItemSenadoresActualesBinding) :
    SenadoresBaseViewHolder<SenadorObject>(binding.root) {

    override fun bind(item: SenadorObject, onItemSelected: () -> Unit) = with(binding) {
        Picasso.get().load(item.picture).into(imageViewSenadorActual)
        textViewNombreSenadorActual.text = item.nombre

        linearLayoutSenadoresActuales.setOnClickListener {
            startRotationAnimation(textViewNombreSenadorActual, newLambda = { onItemSelected() })
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