package pe.edu.ulima.f2reservas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import pe.edu.ulima.f2reservas.databinding.ActivityInformationBinding
import pe.edu.ulima.f2reservas.databinding.ActivityLoginBinding

class InformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

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