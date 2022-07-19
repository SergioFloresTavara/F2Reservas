package pe.edu.ulima.f2reservas.fragments.yourbookings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pe.edu.ulima.f2reservas.R
import pe.edu.ulima.f2reservas.adapter.DataAdapter
import pe.edu.ulima.f2reservas.adapter.DataAdapter2
import pe.edu.ulima.f2reservas.database.Reservasconnect
import pe.edu.ulima.f2reservas.databinding.FragmentB06ReservaExitosaBinding
import pe.edu.ulima.f2reservas.databinding.FragmentY01YourBookingBinding
import pe.edu.ulima.f2reservas.room.DataReservas
import pe.edu.ulima.f2reservas.room.DataYB
import pe.edu.ulima.f2reservas.singleton.Datausuario

class Y01YourBookingFragment : Fragment() {

    private var _binding: FragmentY01YourBookingBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var listaData : List<DataYB> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentY01YourBookingBinding.inflate(inflater, container, false)
        initRecyclerView()




        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun initRecyclerView(){
        val manager = LinearLayoutManager(context)
        val decoration = DividerItemDecoration(context, manager.orientation)
        binding.rvListadodata.layoutManager= manager
        lifecycleScope.launch(Dispatchers.IO){
            listaData = ObtenerBusqueda()}
        lifecycleScope.launch(Dispatchers.Main) {
            binding.rvListadodata.adapter = DataAdapter2(listaData)
            binding.rvListadodata.adapter
        }

    }

    suspend fun ObtenerBusqueda() : List<DataYB> {
        listaData = Reservasconnect.database.resultadosDao().BusquedaYB(Datausuario.nombre.toString())
        return listaData
    }

}