package cl.antoinette.monitor_politico_econmico.ui.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import cl.antoinette.monitor_politico_econmico.R
import cl.antoinette.monitor_politico_econmico.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

   private var _binding: FragmentHomeBinding? = null
   private val binding get() = _binding!!
   private lateinit var navController: NavController
   override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
      _binding = FragmentHomeBinding.inflate(layoutInflater)
      return binding.root
   }

   override fun onViewCreated(
      view: View,
      savedInstanceState: Bundle?
   ) = with(binding) {
      super.onViewCreated(view, savedInstanceState)
      navController = Navigation.findNavController(view)

      buttonIrADipActuales.setOnClickListener {
         navController.navigate(R.id.action_homeFragment_to_diputadosFragment)
      }

      buttonRecall.setOnClickListener {
         if (progressbar.visibility == View.GONE) {
            progressbar.visibility = View.VISIBLE
            badge.visibility = View.GONE
         }else{
            progressbar.visibility = View.GONE
            badge.visibility = View.VISIBLE
         }
      }

   }

   override fun onDestroyView() {
      super.onDestroyView()
      _binding = null
   }
}