package cl.antoinette.monitor_politico_econmico.use_cases.features.senadores.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class SenadoresBaseViewHolder<T>(item: View) : RecyclerView.ViewHolder(item) {

    abstract fun bind(item: T, onItemSelected: () -> Unit)
}
