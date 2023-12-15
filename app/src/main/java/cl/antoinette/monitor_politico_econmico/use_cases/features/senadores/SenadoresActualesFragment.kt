package cl.antoinette.monitor_politico_econmico.use_cases.features.senadores

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import cl.antoinette.monitor_politico_econmico.R
import cl.antoinette.monitor_politico_econmico.databinding.FragmentSenadoresActualesBinding
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

class SenadoresActualesFragment : Fragment() {

    private var _binding: FragmentSenadoresActualesBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSenadoresActualesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        YoYo.with(Techniques.DropOut).duration(500).playOn(binding.textView)
        YoYo.with(Techniques.DropOut).duration(500).playOn(binding.backIcon)
        navController = Navigation.findNavController(view)

        binding.backIcon.setOnClickListener {
            navController.navigate(R.id.action_senadoresFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}