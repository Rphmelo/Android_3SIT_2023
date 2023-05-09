package br.com.fiap.countries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.countries.databinding.ViewCountryItemBinding
import br.com.fiap.countries.model.CountryModel

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.CharacterItemViewHolder>() {

    private var countryList: MutableList<CountryModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterItemViewHolder {
        val binding = ViewCountryItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_country_item,
                parent,
                false
            )
        )
        return CharacterItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterItemViewHolder, position: Int) {
        holder.bindView(countryList[position], position)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun setData(list: List<CountryModel>) {
        with(countryList) {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    inner class CharacterItemViewHolder(
        private val view: ViewCountryItemBinding
    ) : RecyclerView.ViewHolder(view.root) {

        fun bindView(countryInfo: CountryModel, itemPosition: Int) {
            view.countryNameValue.text = countryInfo.name
            view.countryCapitalValue.text = countryInfo.capital
            view.countryLanguageValue.text = countryInfo.language
            view.countryLocationValue.text = countryInfo.location
            view.countryCurrencyValue.text = countryInfo.currency
        }
    }
}