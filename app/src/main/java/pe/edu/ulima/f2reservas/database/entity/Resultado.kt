package pe.edu.ulima.f2reservas.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Resultados")
data class Resultado(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = 0,
    val actividad : String,
    val horario : String,
    val disponibilidad : String,
    val usuario : String? = "",
    val set : String
)