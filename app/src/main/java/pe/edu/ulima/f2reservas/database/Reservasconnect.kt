package pe.edu.ulima.f2reservas.database

import android.app.Application
import androidx.room.Room
import pe.edu.ulima.f2reservas.database.conect.ResultadosDb

class Reservasconnect: Application() {
    companion object{
        lateinit var database: ResultadosDb
    }

    override fun onCreate() {
        super.onCreate()
        Reservasconnect.database = Room.databaseBuilder(this,
            ResultadosDb::class.java,
            "f2reservas-db").build()
    }

}