package br.com.fiap.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.countries.databinding.FragmentRegisterCountryBinding
import br.com.fiap.countries.model.CountryModel
import com.google.android.material.snackbar.Snackbar

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.buttonBackToCountries.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.registerUpdateCountryButton.setOnClickListener {
            insertData()
        }
    }

    private fun insertData() {
        val countryModel = CountryModel(
            name = binding.textInputEditTextCountryName.text.toString(),
            capital = binding.textInputEditTextCountryCapital.text.toString(),
            currency = binding.textInputEditTextCountryCurrency.text.toString(),
            language = binding.textInputEditTextCountryLanguage.text.toString(),
            location = binding.textInputEditTextCountryLocation.text.toString()
        )
        CountriesDataSource.countriesList.add(countryModel)
        clearForm()
        showSnackBar(countryModel.name)
    }

    private fun clearForm() {
        binding.textInputEditTextCountryName.text?.clear()
        binding.textInputEditTextCountryCapital.text?.clear()
        binding.textInputEditTextCountryCurrency.text?.clear()
        binding.textInputEditTextCountryLanguage.text?.clear()
        binding.textInputEditTextCountryLocation.text?.clear()
    }

    private fun showSnackBar(countryName: String) {
        Snackbar.make(
            binding.registerUpdateCountryButton,
            getString(R.string.register_success_message, countryName),
            Snackbar.LENGTH_SHORT
        ).show()
    }

}