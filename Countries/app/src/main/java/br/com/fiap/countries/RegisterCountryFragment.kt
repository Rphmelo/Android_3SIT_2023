package br.com.fiap.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.fiap.countries.databinding.FragmentRegisterCountryBinding

class RegisterCountryFragment : Fragment() {

    lateinit var binding: FragmentRegisterCountryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterCountryBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    private fun insertData() {

    }

}