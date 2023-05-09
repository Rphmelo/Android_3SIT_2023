package br.com.fiap.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.countries.databinding.FragmentCountriesBinding

class CountriesFragment : Fragment() {

    lateinit var binding: FragmentCountriesBinding

    private val countryAdapter = CountryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountriesBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.buttonAddCountry.setOnClickListener {
            findNavController().navigate(
                R.id.action_to_RegisterCountryFragment
            )
        }

        binding.recyclerViewCountries.setHasFixedSize(true)
        binding.recyclerViewCountries.adapter = countryAdapter

        countryAdapter.setData(CountriesDataSource.countriesList)
    }
}