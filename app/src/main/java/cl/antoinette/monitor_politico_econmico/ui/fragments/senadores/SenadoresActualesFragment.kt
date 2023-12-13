package cl.antoinette.monitor_politico_econmico.ui.fragments.senadores

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import cl.antoinette.monitor_politico_econmico.databinding.FragmentSenadoresActualesBinding
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

class SenadoresActualesFragment : Fragment() {

    private var _binding: FragmentSenadoresActualesBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
//	private lateinit var model: SenadoresActualesViewModel
//	private lateinit var adapter: SenadoresActualesAdapter

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSenadoresActualesBinding.inflate(layoutInflater)
//		model = ViewModelProvider(this).get(SenadoresActualesViewModel::class.java)
//		adapter = SenadoresActualesAdapter(mutableListOf(), requireContext())
//		initRecyclerView(binding.recyclerViewSenadoresActuales, requireContext(), adapter)
//		val dialogo = Dialog(requireContext(), R.style.Theme_ScrappingPolitics)
//		val view = this.layoutInflater.inflate(R.layout.fullscreen_progress_bar, null)
//		dialogo.setContentView(view)
//		dialogo.setCancelable(false)
//		dialogo.show()
//		model.senadoresActualesList.observe(viewLifecycleOwner, {
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