package pe.edu.ulima.f2reservas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import pe.edu.ulima.f2reservas.databinding.ActivityInformationBinding
import pe.edu.ulima.f2reservas.singleton.Datausuario

class InformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navigationView: NavigationView = findViewById(R.id.navigation_view)
        val header: View = navigationView.getHeaderView(0)
        val textheader1: TextView = header.findViewById(R.id.nombreHeader)
        val textheader2: TextView = header.findViewById(R.id.correoHeader)
        textheader1.text= Datausuario.NomApe
        textheader2.text= Datausuario.nombre+"@aloe.ulima.edu.pe"


        binding.ReservasBtn.setOnClickListener{
            startActivity(Intent(this,YourBookingsActivity::class.java))
        }

        binding.toolbarNombre.setOnClickListener{
            binding.drawerLayoutI.openDrawer(GravityCompat.START)
        }

        binding.navigationView.setNavigationItemSelectedListener(
            fun(item: MenuItem?): Boolean{
                var id: Int = item!!.itemId
                binding.drawerLayoutI.closeDrawer(GravityCompat.START)
                when(id){
                    R.id.navHome->{
                        startActivity(Intent(this,MainActivity::class.java))
                    }
                    R.id.navYourBookings->{
                        startActivity(Intent(this,YourBookingsActivity::class.java))
                    }
                    R.id.navBooking->{
                        startActivity(Intent(this,BookingActivity::class.java))
                    }
                    R.id.navMoreInfo->{}
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