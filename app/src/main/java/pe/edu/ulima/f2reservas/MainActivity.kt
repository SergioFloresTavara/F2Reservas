package pe.edu.ulima.f2reservas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import pe.edu.ulima.f2reservas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarNombre.setOnClickListener{
            binding.drawerLayoutM.openDrawer(GravityCompat.START)
        }


        binding.navigationView.setNavigationItemSelectedListener(
            fun(item: MenuItem?): Boolean{
                val id: Int = item!!.itemId
                binding.drawerLayoutM.closeDrawer(GravityCompat.START)
                when(id){
                    R.id.navHome->{}
                    R.id.navYourBookings->{
                        startActivity(Intent(this,YourBookingsActivity::class.java))
                    }
                    R.id.navBooking->{
                        startActivity(Intent(this,BookingActivity::class.java))
                    }
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