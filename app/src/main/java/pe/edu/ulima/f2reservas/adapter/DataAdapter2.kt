package pe.edu.ulima.f2reservas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.f2reservas.room.DataYB
import pe.edu.ulima.f2reservas.R


class DataAdapter2(
    private val context : Context,
    private val DataList: List<DataYB>,
    private val onClickListener: (DataYB) -> Unit
    ):
    RecyclerView.Adapter<DataViewHolder2>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder2 {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DataViewHolder2(context,layoutInflater.inflate(R.layout.item_data, parent, false))
    }

    override fun onBindViewHolder(holder: DataViewHolder2, position: Int) {
        holder.render(
            DataList[position],
            onClickListener
        )
    }

    override fun getItemCount(): Int = DataList.size
}