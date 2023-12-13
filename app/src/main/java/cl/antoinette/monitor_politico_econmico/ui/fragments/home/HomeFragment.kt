package cl.antoinette.monitor_politico_econmico.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        buttonIrADipActuales.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_diputadosFragment)
        }

        buttonIrASenActuales.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_senadoresFragment)
        }

        buttonPartPoliticos.setOnClickListener {
//            navController.navigate(R.id.action_homeFragment_to_partidosActualesFragment)
            Toast.makeText(context, "Partidos", Toast.LENGTH_SHORT).show()

        }

        buttonIrAConsejActuales.setOnClickListener {
//            navController.navigate(R.id.action_homeFragment_to_consejalesActualesFragment)
            Toast.makeText(context, "Consejales", Toast.LENGTH_SHORT).show()

        }

        buttonIrAGallery.setOnClickListener {
//            navController.navigate(R.id.action_homeFragment_to_galleryFragment)
            Toast.makeText(context, "Gallery", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}