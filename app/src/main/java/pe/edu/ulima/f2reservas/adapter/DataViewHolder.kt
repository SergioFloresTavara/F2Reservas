package pe.edu.ulima.f2reservas.adapter


import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.f2reservas.database.entity.Resultado
import pe.edu.ulima.f2reservas.R
import pe.edu.ulima.f2reservas.databinding.ItemDataBinding
import pe.edu.ulima.f2reservas.room.DataReservas

class DataViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    val binding = ItemDataBinding.bind(view)

    fun render(resultadoModel: DataReservas){
        binding.tvHorario.text = resultadoModel.horario
        binding.tvSet.text = resultadoModel.set
        binding.tvDispo.text = resultadoModel.disponibilidad
    }
}