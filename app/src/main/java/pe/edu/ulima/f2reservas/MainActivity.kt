package pe.edu.ulima.f2reservas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import pe.edu.ulima.f2reservas.databinding.ActivityMainBinding
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import androidx.lifecycle.lifecycleScope
import com.opencsv.CSVParserBuilder
import com.opencsv.CSVReaderBuilder
import com.opencsv.CSVWriter
import kotlinx.coroutines.launch
import pe.edu.ulima.f2reservas.database.Reservasconnect
import pe.edu.ulima.f2reservas.database.entity.Resultado
import java.io.FileReader
import java.nio.charset.StandardCharsets
import java.io.FileNotFoundException


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var nombre: String? =null
    private var contra: String? =null
    private var guardado: String? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarNombre.setOnClickListener{
            binding.drawerLayoutM.openDrawer(GravityCompat.START)
        }
        binding.GenerarDataBtn.setOnClickListener{
            sincronizar()
            Toast.makeText(
            this,
            "Carga diaria generada",
            Toast.LENGTH_SHORT).show()
        }


        binding.navigationView.setNavigationItemSelectedListener(
            fun(item: MenuItem?): Boolean{
                val id: Int = item!!.itemId
                binding.drawerLayoutM.closeDrawer(GravityCompat.START)
                when(id){
                    R.id.navHome->{}
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
                    R.id.navMoreInfo->{
                        val intent = Intent(this,InformationActivity::class.java)
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

    fun sincronizar():Boolean{
        lifecycleScope.launch(Dispatchers.IO){
            try {
//                C:\Users\SF\Downloads\F2Reservas\app\src\main\res\raw
//                "/F2Reservas/src/main/res/raw/horario.csv"
                val csvReader = CSVReaderBuilder(FileReader("horarios.csv")).build()

                // Read the rest
                var line: Array<String>? = csvReader.readNext()
                while (line != null) {
                    val actividad = line[0]
                    val horario = line[1]
                    var dispo = line[2]
                    var usuario = ""
                    val set = line[4]

                    var resultado = Resultado(null,actividad,horario,dispo,usuario,set)
                    println("gaaaaaaaa")
                    Reservasconnect.database.resultadosDao().insertarResultado(resultado)

                    line = csvReader.readNext()
                }
            }catch(ex: IOException){
                println("nouuuuuuuuuuu"+ex.message+ex.toString())
                Log.d("Exception",ex.toString())
            }
        }
        return true
    }
}