package cl.antoinette.monitor_politico_econmico.use_cases.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cl.antoinette.monitor_politico_econmico.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}


