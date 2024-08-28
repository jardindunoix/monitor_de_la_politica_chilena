package cl.antoinette.monitor_politico_econmico.ui.features.diputados.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cl.antoinette.monitor_politico_econmico.R
import cl.antoinette.monitor_politico_econmico.databinding.FragmentDiputadoDetailBinding

class DiputadoDetailFragment : Fragment() {

   private var _binding: FragmentDiputadoDetailBinding? = null
   private val binding get() = _binding!!

   override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      _binding = FragmentDiputadoDetailBinding.inflate(
         inflater,
         container,
         false
      )
      return binding.root
   }

   override fun onViewCreated(
      view: View,
      savedInstanceState: Bundle?
   ) {
      super.onViewCreated(
         view,
         savedInstanceState
      )

      viewEvents()
   }

   private fun viewEvents() {
      binding.backIcon.setOnClickListener {
         findNavController().navigate(R.id.action_diputadoDetailFragment_to_diputadosFragment)
      }
   }


   override fun onDestroy() {
      super.onDestroy()
   }
}