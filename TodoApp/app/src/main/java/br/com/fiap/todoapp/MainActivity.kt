package br.com.fiap.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.todoapp.databinding.ActivityMainBinding
import br.com.fiap.todoapp.databinding.ViewFilterItemBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupFilters()
    }

    private fun setupFilters() {
        TaskStatus.values().forEach {
            val filterOption = ViewFilterItemBinding.inflate(
                layoutInflater,
                binding.taskFilters,
                false
            )
            filterOption.filter.text = it.title
            binding.taskFilters.addView(filterOption.filter)
        }
    }
}