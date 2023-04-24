package br.com.fiap.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.countries.databinding.ActivityCountriesBinding

class CountriesActivity : AppCompatActivity() {

    lateinit var binding: ActivityCountriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}