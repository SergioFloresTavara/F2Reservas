package pe.edu.ulima.f2reservas.adapter


import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.f2reservas.database.entity.Resultado
import pe.edu.ulima.f2reservas.R
import pe.edu.ulima.f2reservas.databinding.ItemDataBinding
import pe.edu.ulima.f2reservas.room.DataReservas

class DataViewHolder(private val context : Context, view : View) : RecyclerView.ViewHolder(view) {

    val binding = ItemDataBinding.bind(view)

    fun render(resultadoModel: DataReservas,onClickListener: (DataReservas) -> Unit){
        binding.tvHorario.text = resultadoModel.horario
        binding.tvSet.text = resultadoModel.set
        binding.tvDispo.text = resultadoModel.disponibilidad

        itemView.setOnClickListener{
            onClickListener(resultadoModel)
        }
    }
}