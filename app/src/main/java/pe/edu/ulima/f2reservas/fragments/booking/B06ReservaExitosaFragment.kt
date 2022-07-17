package pe.edu.ulima.f2reservas.fragments.booking

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.edu.ulima.f2reservas.*
import pe.edu.ulima.f2reservas.databinding.FragmentB05AjedrezBinding
import pe.edu.ulima.f2reservas.databinding.FragmentB06ReservaExitosaBinding


class B06ReservaExitosaFragment : Fragment() {

    private var _binding: FragmentB06ReservaExitosaBinding? = null
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
        _binding = FragmentB06ReservaExitosaBinding.inflate(inflater, container, false)
        binding.ReservasBtn.setOnClickListener{
            startActivity(Intent(getActivity(), YourBookingsActivity::class.java))
        }
        binding.MasInfoBtn.setOnClickListener{
            startActivity(Intent(getActivity(), InformationActivity::class.java))
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}