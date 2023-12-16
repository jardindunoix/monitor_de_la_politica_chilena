package cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import cl.antoinette.monitor_politico_econmico.R
import cl.antoinette.monitor_politico_econmico.databinding.FragmentDiputadosActualesBinding
import cl.antoinette.monitor_politico_econmico.service.ExtensionFunctions.Companion.initRecyclerView
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.ui.adapter.DiputadosAdapter
import cl.antoinette.monitor_politico_econmico.use_cases.features.diputados.view_model.DiputadosViewModel
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DiputadosFragment : Fragment() {

    private var _binding: FragmentDiputadosActualesBinding? = null
    private val binding get() = _binding!!
//    private lateinit var navController: NavController

    private val model by viewModels<DiputadosViewModel>()
    private lateinit var adapter: DiputadosAdapter

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

        initList()
        initUIState()

        YoYo.with(Techniques.DropOut).duration(500).playOn(binding.textView)
        YoYo.with(Techniques.DropOut).duration(500).playOn(binding.backIcon)
//        navController = Navigation.findNavController(view)

        binding.backIcon.setOnClickListener {
            findNavController().navigate(R.id.action_diputadosFragment_to_homeFragment)
        }
    }


    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                model.diputadosActualesList.observe(viewLifecycleOwner) {
                    adapter.setItemInTheView(it)
                }
            }
        }
    }

    private fun initList() {
        adapter = DiputadosAdapter(mutableListOf(),
            onItemSelected = {
                findNavController().navigate(R.id.action_diputadosFragment_to_diputadoDetailFragment)
            })
        initRecyclerView(binding.recyclerViewDiputadosActuales, requireContext(), adapter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}