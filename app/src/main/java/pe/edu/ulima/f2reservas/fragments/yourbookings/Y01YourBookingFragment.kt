package pe.edu.ulima.f2reservas.fragments.yourbookings

import android.content.Intent
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
import pe.edu.ulima.f2reservas.BookingActivity
import pe.edu.ulima.f2reservas.MainActivity
import pe.edu.ulima.f2reservas.R
import pe.edu.ulima.f2reservas.adapter.DataAdapter2
import pe.edu.ulima.f2reservas.database.Reservasconnect
import pe.edu.ulima.f2reservas.databinding.FragmentY01YourBookingBinding
import pe.edu.ulima.f2reservas.room.DataYB
import pe.edu.ulima.f2reservas.singleton.Datausuario

class Y01YourBookingFragment : Fragment() {

    private var _binding: FragmentY01YourBookingBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var listaData : List<DataYB> = emptyList()
    var act:String?=null
    var horario:String?=null
    var set:String?=null
    var seleccionado="no"

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

        binding.VolverBtn.setOnClickListener{
            startActivity(Intent(context,BookingActivity::class.java))
        }

        binding.EliminarBtn.setOnClickListener{
            if(Datausuario.nombre!="admin" && Datausuario.nombre!=null){
                if(seleccionado=="si"){
                    lifecycleScope.launch(Dispatchers.IO){
                    Reservasconnect.database.resultadosDao().borrarUser(act!!,horario!!, set!!,Datausuario.nombre!!)}
                }else{
                    Toast.makeText(
                        context,
                        "Seleccione una reserva",
                        Toast.LENGTH_SHORT).show()
                }
            }else{
                if(seleccionado=="si"){
                    lifecycleScope.launch(Dispatchers.IO){
                    Reservasconnect.database.resultadosDao().borrarAdmin(act!!,horario!!, set!!)}
                }else{
                    Toast.makeText(
                        context,
                        "Seleccione una reserva",
                        Toast.LENGTH_SHORT).show()
                }
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
            binding.rvListadodata.adapter = DataAdapter2(requireContext(),listaData) {
                seleccionado="si"
                Toast.makeText(
                    context,
                    "Se selecciono la reserva de" + act +" a las " + horario + " en la mesa " + set,
                    Toast.LENGTH_SHORT).show()
                act=it.actividad.toString()
                horario=it.horario.toString()
                set=it.set.toString()

            }
                binding.rvListadodata.adapter}
        }

    }

    suspend fun ObtenerBusqueda() : List<DataYB> {
        if (Datausuario.nombre!="admin") {
            listaData = Reservasconnect.database.resultadosDao().BusquedaYB(Datausuario.nombre!!)
            return listaData
        }else{
            listaData = Reservasconnect.database.resultadosDao().BusquedaAdmin()
            return listaData
        }
    }

}