package pe.edu.ulima.f2reservas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pe.edu.ulima.f2reservas.databinding.ActivityInformationBinding
import pe.edu.ulima.f2reservas.databinding.ActivityLoginBinding

class InformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}