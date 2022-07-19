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
    private var nombre: String? =null
    private var contra: String? =null
    private var guardado: String? =null

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
                        val intent = Intent(this,MainActivity::class.java)
                        nombre = intent.getStringExtra("NOMBRE")
                        contra = intent.getStringExtra("CONTRA")
                        guardado = intent.getStringExtra("G")
                        val data = Bundle()
                        data.putString("NOMBRE",nombre)
                        data.putString("CONTRA",contra)
                        data.putString("G",guardado)
                        intent.putExtras(data)
                        startActivity(intent)
                    }
                    R.id.navYourBookings->{
                        val intent = Intent(this,YourBookingsActivity::class.java)
                        nombre = intent.getStringExtra("NOMBRE")
                        contra = intent.getStringExtra("CONTRA")
                        guardado = intent.getStringExtra("G")
                        val data = Bundle()
                        data.putString("NOMBRE",nombre)
                        data.putString("CONTRA",contra)
                        data.putString("G",guardado)
                        intent.putExtras(data)
                        startActivity(intent)
                    }
                    R.id.navBooking->{
                        val intent = Intent(this,BookingActivity::class.java)
                        nombre = intent.getStringExtra("NOMBRE")
                        contra = intent.getStringExtra("CONTRA")
                        guardado = intent.getStringExtra("G")
                        val data = Bundle()
                        data.putString("NOMBRE",nombre)
                        data.putString("CONTRA",contra)
                        data.putString("G",guardado)
                        intent.putExtras(data)
                        startActivity(intent)
                    }
                    R.id.navMoreInfo->{}
                    R.id.navCerrarSesion->{
                        val intent = Intent(this,LoginActivity::class.java)
                        nombre = intent.getStringExtra("NOMBRE")
                        contra = intent.getStringExtra("CONTRA")
                        guardado = intent.getStringExtra("G")
                        val data = Bundle()
                        data.putString("NOMBRE",nombre)
                        data.putString("CONTRA",contra)
                        data.putString("G",guardado)
                        intent.putExtras(data)
                        startActivity(intent)
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