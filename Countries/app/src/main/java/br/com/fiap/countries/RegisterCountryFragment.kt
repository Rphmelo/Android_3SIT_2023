package br.com.fiap.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.countries.SnackBarUtil.showSnackBar
import br.com.fiap.countries.data.AppDatabase
import br.com.fiap.countries.databinding.FragmentRegisterCountryBinding
import br.com.fiap.countries.data.CountryModel

class RegisterCountryFragment : Fragment() {

    private lateinit var binding: FragmentRegisterCountryBinding
    private val appDb: AppDatabase? by lazy {
        context?.let {
            AppDatabase.getDatabase(it)
        }
    }

    private val countryInfoArgument by lazy {
        arguments?.getParcelable(COUNTRY_MODEL_BUNDLE_KEY) as? CountryModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterCountryBinding.inflate(inflater, container, false)
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

        binding.registerUpdateCountryButton.run {
            text = if(countryInfoArgument == null) {
                getString(R.string.register_country_button_label)
            } else {
                getString(R.string.update_country_button_label)
            }

            setOnClickListener {
                insertUpdateData()
            }
        }

        countryInfoArgument?.let { countryInfoArgument ->
            binding.run {
                textInputEditTextCountryName.setText(countryInfoArgument.name)
                textInputEditTextCountryLanguage.setText(countryInfoArgument.language)
                textInputEditTextCountryCurrency.setText(countryInfoArgument.currency)
                textInputEditTextCountryLocation.setText(countryInfoArgument.location)
                textInputEditTextCountryCapital.setText(countryInfoArgument.capital)
            }
        }
    }

    private fun insertUpdateData() {
        binding.run {
            val countryModel = CountryModel(
                name = textInputEditTextCountryName.text.toString(),
                language = textInputEditTextCountryLanguage.text.toString(),
                currency = textInputEditTextCountryCurrency.text.toString(),
                location = textInputEditTextCountryLocation.text.toString(),
                capital = textInputEditTextCountryCapital.text.toString(),
            )

            countryInfoArgument?.let {
                countryModel.id = it.id
            }

            if(countryInfoArgument == null) {
                appDb?.countryDAO()?.insert(countryModel)
                showSnackBar(
                    binding.registerUpdateCountryButton,
                    getString(R.string.register_country_success_registered_message,
                        countryModel.name
                    )
                )
            } else {
                appDb?.countryDAO()?.update(countryModel)
                showSnackBar(
                    binding.registerUpdateCountryButton,
                    getString(R.string.register_country_success_updated_message,
                        countryModel.name
                    )
                )
            }

            clearForm()
        }
    }

    private fun clearForm() {
        binding.run {
            textInputEditTextCountryName.text?.clear()
            textInputEditTextCountryLanguage.text?.clear()
            textInputEditTextCountryCurrency.text?.clear()
            textInputEditTextCountryLocation.text?.clear()
            textInputEditTextCountryCapital.text?.clear()
        }
    }

    private fun showRegisterMessage(message: String) {
        showSnackBar(binding.buttonBackToCountries, message)
    }

    companion object {
        private const val COUNTRY_MODEL_BUNDLE_KEY = "COUNTRY_MODEL_BUNDLE_KEY"

        fun buildBundle(countryModel: CountryModel?): Bundle? {
            return countryModel?.let {
                bundleOf(COUNTRY_MODEL_BUNDLE_KEY to it)
            }
        }
    }
}