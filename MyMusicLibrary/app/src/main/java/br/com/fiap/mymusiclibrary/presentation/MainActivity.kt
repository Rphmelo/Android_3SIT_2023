package br.com.fiap.mymusiclibrary.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.mymusiclibrary.data.AppDatabase
import br.com.fiap.mymusiclibrary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val musicAdapter by lazy {
        MusicAdapter()
    }
    private val appDb by lazy {
        AppDatabase.getDatabase(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecycler()
        setButtons()
    }

    private fun setRecycler() {
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = musicAdapter

        musicAdapter.setData(appDb.musicDao().selectAll())
    }

    private fun setButtons() {
        binding.favButton.setOnClickListener {
            musicAdapter.setData(appDb.musicDao().selectBy(true))
        }

        binding.noFavButton.setOnClickListener {
            musicAdapter.setData(appDb.musicDao().selectBy(false))
        }
    }
}