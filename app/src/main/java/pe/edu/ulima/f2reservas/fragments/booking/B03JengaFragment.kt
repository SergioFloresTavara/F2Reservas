package pe.edu.ulima.f2reservas.fragments.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.edu.ulima.f2reservas.R
import pe.edu.ulima.f2reservas.databinding.FragmentB02PpBinding
import pe.edu.ulima.f2reservas.databinding.FragmentB03JengaBinding

class B03JengaFragment : Fragment() {

    private var _binding: FragmentB03JengaBinding? = null
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
        _binding = FragmentB03JengaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}