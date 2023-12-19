package cl.antoinette.monitor_politico_econmico.use_cases.features.senadores.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cl.antoinette.monitor_politico_econmico.R
import cl.antoinette.monitor_politico_econmico.databinding.FragmentSenadoresActualesBinding
import cl.antoinette.monitor_politico_econmico.service.ExtensionFunctions
import cl.antoinette.monitor_politico_econmico.service.StaticUtils.Companion.YOYO_DURATION
import cl.antoinette.monitor_politico_econmico.use_cases.features.senadores.ui.adapter.SenadoresAdapter
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

class SenadoresFragment : Fragment() {


    private lateinit var adapter: SenadoresAdapter
    private var _binding: FragmentSenadoresActualesBinding? = null
    private val binding get() = _binding!!

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
        initList()
        initUIState()
        uiEvents()

    }

    private fun initUIState() {

    }

    private fun initList() {
        adapter = SenadoresAdapter(mutableListOf(),
            onItemSelected = {
                findNavController().navigate(R.id.action_diputadosFragment_to_diputadoDetailFragment)
            })
        ExtensionFunctions.initRecyclerView(binding.recyclerViewSenadoresActuales, requireContext(), adapter)
    }

    private fun uiEvents() {
        YoYo.with(Techniques.DropOut).duration(YOYO_DURATION).playOn(binding.textView)
        YoYo.with(Techniques.DropOut).duration(YOYO_DURATION).playOn(binding.backIcon)

        binding.backIcon.setOnClickListener {
            findNavController().navigate(R.id.action_senadoresFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}