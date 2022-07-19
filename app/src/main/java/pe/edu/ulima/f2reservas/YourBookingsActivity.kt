package pe.edu.ulima.f2reservas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.room.Room
import pe.edu.ulima.f2reservas.database.Reservasconnect
import pe.edu.ulima.f2reservas.database.conect.ResultadosDb
import pe.edu.ulima.f2reservas.databinding.ActivityMainBinding
import pe.edu.ulima.f2reservas.databinding.ActivityYourBookingsBinding
import pe.edu.ulima.f2reservas.fragments.booking.B01AmbienteFragment
import pe.edu.ulima.f2reservas.fragments.yourbookings.Y01YourBookingFragment

class YourBookingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityYourBookingsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYourBookingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Reservasconnect.database = Room.databaseBuilder(this,
            ResultadosDb::class.java,
            "f2reservas").build()

        supportFragmentManager.beginTransaction().add(binding.fragmentContainerView.id,
            Y01YourBookingFragment()
        ).commit()


        binding.toolbarNombre.setOnClickListener{
            binding.drawerLayoutYB.openDrawer(GravityCompat.START)
        }


        binding.navigationView.setNavigationItemSelectedListener(
            fun(item: MenuItem?): Boolean{
                var id: Int = item!!.itemId
                binding.drawerLayoutYB.closeDrawer(GravityCompat.START)
                when(id){
                    R.id.navHome->{
                        startActivity(Intent(this,MainActivity::class.java))
                    }
                    R.id.navYourBookings->{}
                    R.id.navBooking->{
                        startActivity(Intent(this,BookingActivity::class.java))
                    }
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