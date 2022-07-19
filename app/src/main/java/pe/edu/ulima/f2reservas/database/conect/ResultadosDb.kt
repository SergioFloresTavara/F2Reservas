package pe.edu.ulima.f2reservas.database.conect


import androidx.room.Database
import androidx.room.RoomDatabase
import pe.edu.ulima.f2reservas.database.dao.ResultadosDao
import pe.edu.ulima.f2reservas.database.entity.Resultado


@Database(
    entities = [Resultado::class],
    version = 1,
    exportSchema = false
)
abstract class ResultadosDb : RoomDatabase(){

    abstract fun resultadosDao() : ResultadosDao

}