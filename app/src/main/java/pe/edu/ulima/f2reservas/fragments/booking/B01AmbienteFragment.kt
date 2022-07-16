package pe.edu.ulima.f2reservas.fragments.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.edu.ulima.f2reservas.R
import pe.edu.ulima.f2reservas.databinding.FragmentB01AmbienteBinding


class B01AmbienteFragment : Fragment() {

    private var _binding: FragmentB01AmbienteBinding? = null
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
        _binding = FragmentB01AmbienteBinding.inflate(inflater, container, false)

        binding.PPBtn.setOnClickListener{
            fragmentManager?.beginTransaction()!!.replace(R.id.fragmentContainerView,B02PpFragment()).commit()
        }
        binding.JengaBtn.setOnClickListener{
            fragmentManager?.beginTransaction()!!.replace(R.id.fragmentContainerView,B03JengaFragment()).commit()
        }
        binding.AjedrezBtn.setOnClickListener{
            fragmentManager?.beginTransaction()!!.replace(R.id.fragmentContainerView,B04CubiculosFragment()).commit()
        }
        binding.CubiculoBtn.setOnClickListener{
            fragmentManager?.beginTransaction()!!.replace(R.id.fragmentContainerView,B05AjedrezFragment()).commit()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}