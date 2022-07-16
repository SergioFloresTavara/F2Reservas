package pe.edu.ulima.f2reservas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import pe.edu.ulima.f2reservas.databinding.ActivityBookingBinding
import pe.edu.ulima.f2reservas.databinding.ActivityInformationBinding

class BookingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
                    R.id.navBooking->{}
                    R.id.navMoreInfo->{
                        startActivity(Intent(this,InformationActivity::class.java))
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