package pe.edu.ulima.f2reservas.fragments.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.edu.ulima.f2reservas.R
import pe.edu.ulima.f2reservas.databinding.FragmentB06ReservaExitosaBinding
import pe.edu.ulima.f2reservas.databinding.FragmentL01LoginBinding


class L01LoginFragment : Fragment() {


    private var _binding: FragmentL01LoginBinding? = null
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
        _binding = FragmentL01LoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}