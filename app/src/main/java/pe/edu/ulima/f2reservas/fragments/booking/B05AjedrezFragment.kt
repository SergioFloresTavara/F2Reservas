package pe.edu.ulima.f2reservas.fragments.booking

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
import pe.edu.ulima.f2reservas.database.Reservasconnect
import pe.edu.ulima.f2reservas.databinding.FragmentB04CubiculosBinding
import pe.edu.ulima.f2reservas.databinding.FragmentB05AjedrezBinding
import pe.edu.ulima.f2reservas.room.DataReservas


class B05AjedrezFragment : Fragment() {

    private var _binding: FragmentB05AjedrezBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var listaData : List<DataReservas> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentB05AjedrezBinding.inflate(inflater, container, false)
        binding.VolverBtn.setOnClickListener{
            fragmentManager?.beginTransaction()!!.replace(R.id.fragmentContainerView,B01AmbienteFragment()).commit()
        }

        initRecyclerView()

        //////LOGICA RESERVA PINTANDO RECYCLER
        binding.ReservarBtn.setOnClickListener{
            fragmentManager?.beginTransaction()!!.replace(R.id.fragmentContainerView,B06ReservaExitosaFragment()).commit()
        }

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
        lifecycleScope.launch(Dispatchers.IO){ listaData = ObtenerBusqueda()}
        lifecycleScope.launch(Dispatchers.Main) {
            binding.rvListadodata.adapter = DataAdapter(listaData)
            binding.rvListadodata.adapter}

    }

    suspend fun ObtenerBusqueda() : List<DataReservas> {
        listaData = Reservasconnect.database.resultadosDao().BusquedaAmb("Ajedrez")
        return listaData
    }


}