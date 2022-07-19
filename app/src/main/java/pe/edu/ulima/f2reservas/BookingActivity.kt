package pe.edu.ulima.f2reservas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.room.Room
import com.google.android.material.navigation.NavigationView
import pe.edu.ulima.f2reservas.database.Reservasconnect
import pe.edu.ulima.f2reservas.database.conect.ResultadosDb
import pe.edu.ulima.f2reservas.databinding.ActivityBookingBinding
import pe.edu.ulima.f2reservas.databinding.ActivityInformationBinding
import pe.edu.ulima.f2reservas.fragments.booking.B01AmbienteFragment
import pe.edu.ulima.f2reservas.fragments.booking.B02PpFragment
import pe.edu.ulima.f2reservas.singleton.Datausuario

class BookingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navigationView: NavigationView = findViewById(R.id.navigation_view)
        val header: View = navigationView.getHeaderView(0)
        val textheader1: TextView = header.findViewById(R.id.nombreHeader)
        val textheader2: TextView = header.findViewById(R.id.correoHeader)
        textheader1.text= Datausuario.NomApe
        textheader2.text= Datausuario.nombre+"@aloe.ulima.edu.pe"



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