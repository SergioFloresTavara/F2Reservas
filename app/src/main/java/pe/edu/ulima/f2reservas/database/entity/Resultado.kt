package pe.edu.ulima.f2reservas.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Resultados")
data class Resultado(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = 0,
    var actividad : String,
    var horario : String,
    var disponibilidad : String,
    var usuario : String,
    var set : String
)