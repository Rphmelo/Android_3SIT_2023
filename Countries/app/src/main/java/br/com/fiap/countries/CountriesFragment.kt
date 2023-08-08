package br.com.fiap.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.countries.databinding.FragmentCountriesBinding
import br.com.fiap.countries.data.CountryModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CountriesFragment : Fragment() {

    lateinit var binding: FragmentCountriesBinding

    private val countryAdapter by lazy {
        CountryAdapter(
            onDeleteListener = ::openConfirmationDeleteDialog,
            onUpdateListener = ::updateCountry
        )
    }

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

    private fun updateCountry(countryModel: CountryModel) {
        goToRegisterCountry(countryModel)
    }

    private fun goToRegisterCountry(countryModel: CountryModel? = null) {
        findNavController().navigate(R.id.action_to_RegisterCountryFragment, RegisterCountryFragment.buildBundle(countryModel))
    }

    private fun deleteCountry(countryModel: CountryModel) {
        SnackBarUtil.showSnackBar(
            binding.recyclerViewCountries,
            getString(R.string.register_country_success_deleted_message,
                countryModel.name
            )
        )

        getDataFromDatabase()
    }

    private fun getDataFromDatabase() {
        countryAdapter.setData(CountriesDataSource.countriesList)
    }

    private fun setupViews() {
        binding.buttonAddCountry.setOnClickListener {
            findNavController().navigate(
                R.id.action_to_RegisterCountryFragment
            )
        }

        binding.recyclerViewCountries.setHasFixedSize(true)
        binding.recyclerViewCountries.adapter = countryAdapter

        getDataFromDatabase()
    }

    private fun openConfirmationDeleteDialog(countryModel: CountryModel) {
        context?.let {
            MaterialAlertDialogBuilder(it)
                .setTitle(resources.getString(R.string.delete_dialog_title))
                .setMessage(resources.getString(R.string.delete_dialog_message, countryModel.name))
                .setNeutralButton(resources.getString(R.string.delete_cancel_label)) { dialog, _ ->
                    dialog.cancel()
                }
                .setPositiveButton(resources.getString(R.string.delete_continue_label)) { dialog, _ ->
                    deleteCountry(countryModel)
                    dialog.dismiss()
                }
                .show()
        }
    }
}