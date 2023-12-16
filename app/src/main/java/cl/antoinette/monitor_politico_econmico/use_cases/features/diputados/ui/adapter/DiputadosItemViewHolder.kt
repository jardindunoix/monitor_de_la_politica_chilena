package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.ui.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import cl.antoinette.monitor_politico_econmico.databinding.ItemDiputadosActualesBinding
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.domain.model.DiputadoObject
import com.squareup.picasso.Picasso

class DiputadosItemViewHolder(private val binding: ItemDiputadosActualesBinding) :
    DiputadosBaseViewHolder<DiputadoObject>(binding.root) {

    override fun bind(item: DiputadoObject, onItemSelected: () -> Unit) = with(binding) {
        Picasso.get().load(item.picture).into(imageViewDiputadoActual)
        textViewNombreDiputadoActual.text = item.nombre

        textViewNombreDiputadoActual.setOnClickListener {
            startRotationAnimation(textViewNombreDiputadoActual, newLambda = { onItemSelected() })
        }
    }

    private fun startRotationAnimation(view: View, newLambda: () -> Unit) {
//        YoYo.with(Techniques.FadeOut).duration(500).playOn(view)
//        newLambda()
        view.animate().apply {
            duration = 900
            interpolator = LinearInterpolator()
            scaleX(2f)
            withEndAction { newLambda() }
            start()
        }
    }
}