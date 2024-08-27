package cl.antoinette.monitor_politico_econmico.use_cases.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import cl.antoinette.monitor_politico_econmico.MonitorApp
import cl.antoinette.monitor_politico_econmico.databinding.ActivityMainBinding
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      binding = ActivityMainBinding.inflate(layoutInflater)
      setContentView(binding.root)
   }
}


