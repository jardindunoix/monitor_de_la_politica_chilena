package cl.antoinette.monitor_politico_econmico.ui.use_cases.home

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
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

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

        YoYo.with(Techniques.FadeInLeft).duration(180).playOn(buttonIrADipActuales)
        YoYo.with(Techniques.FadeInLeft).duration(230).playOn(buttonIrASenActuales)
        YoYo.with(Techniques.FadeInLeft).duration(280).playOn(buttonPartPoliticos)
        YoYo.with(Techniques.FadeInLeft).duration(330).playOn(buttonIrAConsejActuales)
        YoYo.with(Techniques.FadeInLeft).duration(380).playOn(buttonIrAGallery)

        buttonIrADipActuales.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_diputadosFragment)
        }

        buttonIrASenActuales.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_senadoresFragment)
        }

        buttonPartPoliticos.setOnClickListener {
            Toast.makeText(context, "Partidos", Toast.LENGTH_SHORT).show()

        }

        buttonIrAConsejActuales.setOnClickListener {
            Toast.makeText(context, "Consejales", Toast.LENGTH_SHORT).show()
        }

        buttonIrAGallery.setOnClickListener {
            Toast.makeText(context, "Gallery", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}