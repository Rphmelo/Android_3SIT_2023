package br.com.fiap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickAndroid()
        clickIos()
    }

    private fun clickAndroid() {
        binding.optionAndroid.setOnClickListener {
            binding.optionSelected.text = getString(R.string.android_value)
        }
    }

    private fun clickIos() {
        binding.optionIos.setOnClickListener {
            binding.optionSelected.text = getString(R.string.ios_value)
        }
    }

}