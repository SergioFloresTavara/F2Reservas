package pe.edu.ulima.f2reservas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.f2reservas.room.DataYB
import pe.edu.ulima.f2reservas.R

class DataAdapter2(
    private val DataList: List<DataYB>):
    RecyclerView.Adapter<DataViewHolder2>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder2 {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DataViewHolder2(layoutInflater.inflate(R.layout.item_data, parent, false))
    }

    override fun onBindViewHolder(holder: DataViewHolder2, position: Int) {
        val item = DataList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = DataList.size
}