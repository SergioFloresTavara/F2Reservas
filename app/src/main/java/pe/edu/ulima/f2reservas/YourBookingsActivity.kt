package pe.edu.ulima.f2reservas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pe.edu.ulima.f2reservas.databinding.ActivityMainBinding
import pe.edu.ulima.f2reservas.databinding.ActivityYourBookingsBinding

class YourBookingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityYourBookingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYourBookingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}