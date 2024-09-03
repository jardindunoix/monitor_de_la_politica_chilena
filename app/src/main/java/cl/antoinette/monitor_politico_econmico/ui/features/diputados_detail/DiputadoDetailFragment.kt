package cl.antoinette.monitor_politico_econmico.ui.features.diputados_detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import cl.antoinette.monitor_politico_econmico.R
import cl.antoinette.monitor_politico_econmico.databinding.FragmentDiputadoDetailBinding
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DiputadoDetailFragment : Fragment() {

   private var _binding: FragmentDiputadoDetailBinding? = null
   private val binding get() = _binding!!
   private val diputadosDetailViewModel by viewModels<DiputadoDetailViewModel>()

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

      val idDiputado = arguments?.getString("id")
      val webDiputado = arguments?.getString("web")

      viewEvents()

      lifecycleScope.launch(Dispatchers.IO) {
         diputadosDetailViewModel.getDiputadosActualesList(idDiputado!!, webDiputado!!)
      }
   }

   private fun viewEvents() {
      binding.backIcon.setOnClickListener {
         findNavController().navigate(R.id.action_diputadoDetailFragment_to_diputadosFragment)
      }
   }

   override fun onDestroy() {
      super.onDestroy()
      _binding = null
   }
}