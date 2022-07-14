package pe.edu.ulima.f2reservas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pe.edu.ulima.f2reservas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}