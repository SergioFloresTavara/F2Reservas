package pe.edu.ulima.f2reservas

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import pe.edu.ulima.f2reservas.databinding.ActivityMainBinding
import java.net.HttpURLConnection
import java.net.URL
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.google.android.material.navigation.NavigationView
import com.opencsv.CSVParserBuilder
import com.opencsv.CSVReaderBuilder
import com.opencsv.CSVWriter
import kotlinx.coroutines.launch
import pe.edu.ulima.f2reservas.database.Reservasconnect
import pe.edu.ulima.f2reservas.database.conect.ResultadosDb
import pe.edu.ulima.f2reservas.database.entity.Resultado
import pe.edu.ulima.f2reservas.singleton.Datausuario
import java.io.*
import java.nio.charset.StandardCharsets


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navigationView: NavigationView = findViewById(R.id.navigation_view)
        val header: View = navigationView.getHeaderView(0)
        val textheader1: TextView = header.findViewById(R.id.nombreHeader)
        val textheader2: TextView = header.findViewById(R.id.correoHeader)
        textheader1.text= Datausuario.NomApe
        textheader2.text= Datausuario.nombre+"@aloe.ulima.edu.pe"


        if (Datausuario.nombre=="admin") {
            binding.ReservaBtn.setVisibility(View.INVISIBLE)
            binding.GenerarDataBtn.setVisibility(View.VISIBLE)
            binding.descripAdmin.setVisibility(View.VISIBLE)
            binding.descripUsr.setVisibility(View.INVISIBLE)
            binding.descripcionUsr2.setVisibility(View.INVISIBLE)
        }
        binding.ReservaBtn.setOnClickListener{
            startActivity(Intent(this,BookingActivity::class.java))
        }

        binding.toolbarNombre.setOnClickListener{
            binding.drawerLayoutM.openDrawer(GravityCompat.START)
        }
        binding.GenerarDataBtn.setOnClickListener{
            Reservasconnect.database = Room.databaseBuilder(this,
                ResultadosDb::class.java,
                "f2reservas").build()
            limpiar()
            sincronizar()

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
    fun limpiar(){
        lifecycleScope.launch(Dispatchers.IO){
        var nelementos = Reservasconnect.database.resultadosDao().getCount()
        if(nelementos == 0){
            Log.d("s","No hay que borrar")
        }else{
            Reservasconnect.database.resultadosDao().nukeTable()
            Log.d("s","Borrado")
        }}
    }

    fun sincronizar():Boolean{
        lifecycleScope.launch(Dispatchers.IO){
            runOnUiThread(Runnable {
                binding.pgBar1!!.visibility = View.VISIBLE
                binding.pgBar1!!.isIndeterminate = true
            })
            try {
                val minput=InputStreamReader(assets.open("horario.csv"))
                val reader = BufferedReader(minput)
                var line: String
                var correcto:String="BIEN"
                while (reader.readLine().also { line = it } != null) {
                    var row: List<String> = line.split(",")
                    var actividad = row[0].toString()
                    var horario = row[1].toString()
                    var dispo = row[2].toString()
                    var set = row[3].toString()

                    var resultado = Resultado(null, actividad, horario, dispo, "null", set)
                    println("gaaaaaaaa" + resultado.toString())
                    Reservasconnect.database.resultadosDao().insertarResultado(resultado)
                    if (actividad=="Cubículo" && horario=="20:00-21:00" && dispo=="Disponible" && set=="6"){
                        runOnUiThread(Runnable {
                        binding.pgBar1!!.isIndeterminate = false
                        binding.pgBar1!!.progress = 100
                        Toast.makeText(
                            this@MainActivity,
                            "Data diaria cargada",
                            Toast.LENGTH_SHORT).show()

                        })
                        break
                    }
                }
            }catch(ex: IOException){
                Log.d("Exception",ex.toString())
            }
        }
        return true
    }
}