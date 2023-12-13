package cl.antoinette.monitor_politico_econmico.ui.fragments.diputados

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import cl.antoinette.monitor_politico_econmico.R
import cl.antoinette.monitor_politico_econmico.databinding.FragmentDiputadosActualesBinding
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

class DiputadosActualesFragment : Fragment() {

    private var _binding: FragmentDiputadosActualesBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
//	private lateinit var model: DiputadosActualesViewModel
//	private lateinit var adapter: DiputadosActualesAdapter

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiputadosActualesBinding.inflate(layoutInflater)
//		model = ViewModelProvider(this).get(DiputadosActualesViewModel::class.java)
//		adapter = DiputadosActualesAdapter(mutableListOf(), requireContext())
//		initRecyclerView(binding.recyclerViewDiputadosActuales, requireContext(), adapter)
        val dialogo = Dialog(requireContext(), R.style.Theme_MonitorPolíticoEconómico)
//		val view = this.layoutInflater.inflate(R.layout.fullscreen_progress_bar, null)
//		dialogo.setContentView(view)
//		dialogo.setCancelable(false)
//		dialogo.show()
//		model.diputadosActualesList.observe(viewLifecycleOwner, {
//			adapter.setItemInTheView(it)
//			if (it.isNotEmpty()) {
//				dialogo.dismiss()
//			}
//		})
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        YoYo.with(Techniques.Tada).duration(1000).playOn(binding.textView)
        navController = Navigation.findNavController(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}