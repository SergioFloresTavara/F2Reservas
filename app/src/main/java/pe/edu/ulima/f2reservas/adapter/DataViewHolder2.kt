package pe.edu.ulima.f2reservas.adapter


import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.f2reservas.database.entity.Resultado
import pe.edu.ulima.f2reservas.R
import pe.edu.ulima.f2reservas.databinding.ItemDatayourbookingsBinding
import pe.edu.ulima.f2reservas.room.DataReservas
import pe.edu.ulima.f2reservas.room.DataYB

class DataViewHolder2(private val context : Context, view : View) : RecyclerView.ViewHolder(view) {

    val binding = ItemDatayourbookingsBinding.bind(view)

    fun render(resultadoModel: DataYB,onClickListener: (DataYB) -> Unit){
        binding.tvAct.text = resultadoModel.actividad
        binding.tvHor.text = resultadoModel.horario
        binding.tvSt.text = resultadoModel.set

        itemView.setOnClickListener{
            onClickListener(resultadoModel)
        }
    }
}