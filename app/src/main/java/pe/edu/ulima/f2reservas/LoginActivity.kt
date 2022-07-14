package pe.edu.ulima.f2reservas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pe.edu.ulima.f2reservas.databinding.ActivityLoginBinding
import pe.edu.ulima.f2reservas.databinding.ActivityYourBookingsBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}