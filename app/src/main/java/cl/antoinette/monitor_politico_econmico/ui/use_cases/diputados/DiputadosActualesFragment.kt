package cl.antoinette.monitor_politico_econmico.ui.use_cases.diputados

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import cl.antoinette.monitor_politico_econmico.R
import cl.antoinette.monitor_politico_econmico.databinding.FragmentDiputadosActualesBinding
import cl.antoinette.monitor_politico_econmico.service.ExtensionFunctions.Companion.initRecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

class DiputadosActualesFragment : Fragment() {

    private var _binding: FragmentDiputadosActualesBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private lateinit var model: DiputadosActualesViewModel
    private lateinit var adapter: DiputadosActualesAdapter
    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiputadosActualesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProvider(this).get(DiputadosActualesViewModel::class.java)
        adapter = DiputadosActualesAdapter(mutableListOf(), requireContext())
        initRecyclerView(binding.recyclerViewDiputadosActuales, requireContext(), adapter)
        model.diputadosActualesList.observe(viewLifecycleOwner) {
            adapter.setItemInTheView(it)
        }

        YoYo.with(Techniques.DropOut).duration(500).playOn(binding.textView)
        YoYo.with(Techniques.DropOut).duration(500).playOn(binding.backIcon)
        navController = Navigation.findNavController(view)

        binding.backIcon.setOnClickListener {
            navController.navigate(R.id.action_diputadosFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}