package pe.edu.ulima.f2reservas.database.dao

import android.text.Editable
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pe.edu.ulima.f2reservas.database.entity.Resultado
import pe.edu.ulima.f2reservas.room.DataReservas
import pe.edu.ulima.f2reservas.room.DataYB

@Dao
interface ResultadosDao{

    @Insert
    fun insertarResultado(resultado: Resultado)

    @Query("SELECT actividad,horario,`set` FROM Resultados WHERE usuario not like '' ")
    fun getAllAdmin() : List<DataYB>

    @Query("SELECT horario,`set`,disponibilidad FROM Resultados WHERE actividad =:actividad_resultado")
    fun BusquedaAmb(actividad_resultado: String) : List<DataReservas>

    @Query("SELECT actividad,horario,`set` FROM Resultados WHERE usuario =:usuario_resultado")
    fun BusquedaYB(usuario_resultado: String) : List<DataYB>

    @Query("UPDATE Resultados SET usuario =:usuario_resul AND disponibilidad ='Reservado'  WHERE actividad =:actividad_resul and horario =:horario_resul and `set` =:set_resul")
    fun ReservaAmb(actividad_resul: String,horario_resul: String,set_resul: String,usuario_resul: String)

    @Query("UPDATE Resultados SET usuario = '' AND disponibilidad ='Disponible' WHERE actividad =:actividad_resul and horario =:horario_resul and `set` =:set_resul")
    fun borrarUser(actividad_resul: String,horario_resul: String,set_resul: String)

    @Query("UPDATE Resultados SET usuario = '' AND disponibilidad ='Disponible' WHERE actividad =:actividad_resul and horario =:horario_resul and `set` =:set_resul")
    fun borrarAdmin(actividad_resul: String,horario_resul: String,set_resul: String)


}