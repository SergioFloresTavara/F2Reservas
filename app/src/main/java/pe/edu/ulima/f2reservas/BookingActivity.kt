package pe.edu.ulima.f2reservas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.core.view.GravityCompat
import androidx.room.Room
import pe.edu.ulima.f2reservas.database.Reservasconnect
import pe.edu.ulima.f2reservas.database.conect.ResultadosDb
import pe.edu.ulima.f2reservas.databinding.ActivityBookingBinding
import pe.edu.ulima.f2reservas.databinding.ActivityInformationBinding
import pe.edu.ulima.f2reservas.fragments.booking.B01AmbienteFragment
import pe.edu.ulima.f2reservas.fragments.booking.B02PpFragment

class BookingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Reservasconnect.database = Room.databaseBuilder(this,
            ResultadosDb::class.java,
            "f2reservas").build()

        supportFragmentManager.beginTransaction().add(binding.fragmentContainerView.id,B01AmbienteFragment()).commit()

        binding.toolbarNombre.setOnClickListener{
            binding.drawerLayoutB.openDrawer(GravityCompat.START)
        }


        binding.navigationView.setNavigationItemSelectedListener(
            fun(item: MenuItem?): Boolean{
                var id: Int = item!!.itemId
                binding.drawerLayoutB.closeDrawer(GravityCompat.START)
                when(id){
                    R.id.navHome->{
                        startActivity(Intent(this,MainActivity::class.java))
                    }
                    R.id.navYourBookings->{
                        startActivity(Intent(this,YourBookingsActivity::class.java))
                    }
                    R.id.navBooking->{
                        supportFragmentManager?.beginTransaction()!!.replace(R.id.fragmentContainerView,B01AmbienteFragment()).commit()}
                    R.id.navMoreInfo->{
                        startActivity(Intent(this,InformationActivity::class.java))
                    }
                    R.id.navCerrarSesion->{
                        startActivity(Intent(this,LoginActivity::class.java))
                    }
                    else->{
                        return true
                    }
                }
                return true
            }
        )
    }
}