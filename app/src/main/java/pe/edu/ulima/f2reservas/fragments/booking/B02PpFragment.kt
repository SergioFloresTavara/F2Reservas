package pe.edu.ulima.f2reservas.fragments.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.edu.ulima.f2reservas.R
import pe.edu.ulima.f2reservas.databinding.FragmentB01AmbienteBinding
import pe.edu.ulima.f2reservas.databinding.FragmentB02PpBinding


class B02PpFragment : Fragment() {

    private var _binding: FragmentB02PpBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentB02PpBinding.inflate(inflater, container, false)
        binding.VolverBtn.setOnClickListener{
            fragmentManager?.beginTransaction()!!.replace(R.id.fragmentContainerView,B01AmbienteFragment()).commit()
        }






        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}