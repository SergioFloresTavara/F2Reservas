package pe.edu.ulima.f2reservas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pe.edu.ulima.f2reservas.databinding.ActivityBookingBinding
import pe.edu.ulima.f2reservas.databinding.ActivityInformationBinding

class BookingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}