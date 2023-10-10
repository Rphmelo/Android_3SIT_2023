package br.com.fiap.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.ViewCompat
import androidx.core.view.children
import androidx.lifecycle.lifecycleScope
import br.com.fiap.todoapp.database.AppDatabase
import br.com.fiap.todoapp.databinding.ActivityMainBinding
import br.com.fiap.todoapp.databinding.ViewFilterItemBinding
import com.google.android.material.chip.Chip
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val taskAdapter by lazy {
        TaskAdapter()
    }
    private val viewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupFilters()
        getFilteredList()
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.recyclerViewTasks.setHasFixedSize(true)
        binding.recyclerViewTasks.adapter = taskAdapter
    }

    private fun setupFilters() {
        TaskStatus.values().forEach {
            val filterOption = ViewFilterItemBinding.inflate(
                layoutInflater,
                binding.taskFilters,
                false
            ).root as? Chip
            filterOption?.id = ViewCompat.generateViewId()
            filterOption?.text = it.title
            filterOption?.isChecked = it.title == viewModel.selectedFilter?.title
            binding.taskFilters.addView(filterOption)
        }

        binding.taskFilters.setOnCheckedChangeListener { group, checkedId ->
            val checkedChip: Chip? = group.children.find {
                it.id == checkedId
            } as? Chip

            if(checkedChip == null) {
                viewModel.selectedFilter = null
            } else {
                val taskStatusCheckedChip = TaskStatus.getByTitle(checkedChip?.text.toString())
                viewModel.selectedFilter = taskStatusCheckedChip
            }

            getFilteredList()
        }

    }

    private fun getTaskList() {
        lifecycleScope.launch {
            taskAdapter.setData(viewModel.selectAll())
        }
    }

    private fun getTaskFromStatus(status: TaskStatus) {
        lifecycleScope.launch {
            taskAdapter.setData(viewModel.selectByStatus(status))
        }
    }

    private fun getFilteredList() {
        if(viewModel.selectedFilter == null) {
            getTaskList()
        } else {
            getTaskFromStatus(viewModel.selectedFilter!!)
        }
    }
}