package pe.edu.ulima.f2reservas.fragments.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pe.edu.ulima.f2reservas.R
import pe.edu.ulima.f2reservas.adapter.DataAdapter
import pe.edu.ulima.f2reservas.database.Reservasconnect
import pe.edu.ulima.f2reservas.databinding.FragmentB03JengaBinding
import pe.edu.ulima.f2reservas.databinding.FragmentB04CubiculosBinding
import pe.edu.ulima.f2reservas.room.DataReservas
import pe.edu.ulima.f2reservas.singleton.Datausuario

class B04CubiculosFragment : Fragment() {

    private var _binding: FragmentB04CubiculosBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var listaData : List<DataReservas> = emptyList()
    var horario:String?=null
    var set:String?=null
    var disponibilidad:String?=null
    var seleccionado="no"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentB04CubiculosBinding.inflate(inflater, container, false)
        binding.VolverBtn.setOnClickListener{
            fragmentManager?.beginTransaction()!!.replace(R.id.fragmentContainerView,B01AmbienteFragment()).commit()
        }
        initRecyclerView()

        binding.ReservarBtn.setOnClickListener{
            if(seleccionado=="si"){
                lifecycleScope.launch(Dispatchers.IO){
                Reservasconnect.database.resultadosDao().ReservaAmb("Ping pong",horario!!, set!!, Datausuario.nombre!!)
                lifecycleScope.launch(Dispatchers.Main) {fragmentManager?.beginTransaction()!!.replace(R.id.fragmentContainerView,B06ReservaExitosaFragment()).commit()}}
            }else{
                Toast.makeText(
                    context,
                    "Seleccione una reserva",
                    Toast.LENGTH_SHORT).show()
            }
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
        lifecycleScope.launch(Dispatchers.IO){
            listaData = ObtenerBusqueda()
            lifecycleScope.launch(Dispatchers.Main) {
                binding.rvListadodata.adapter = DataAdapter(requireContext(),listaData){
                    seleccionado="si"
                    Toast.makeText(
                        context,
                        "Se selecciono la reserva de Cubículos a las " + horario + " en el cubículo " + set,
                        Toast.LENGTH_SHORT).show()
                    horario=it.horario.toString()
                    set=it.disponibilidad.toString()
                    disponibilidad=it.set.toString()

                }
                binding.rvListadodata.adapter}
        }

    }

    suspend fun ObtenerBusqueda() : List<DataReservas> {
        listaData = Reservasconnect.database.resultadosDao().BusquedaAmb("Cubículo")
        return listaData
    }


}