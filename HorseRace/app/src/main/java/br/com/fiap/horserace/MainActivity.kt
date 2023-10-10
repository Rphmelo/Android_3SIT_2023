package br.com.fiap.horserace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import br.com.fiap.horserace.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: HorseRaceViewModel by viewModels()
    private var coroutine: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setButtons()
    }

    private fun setButtons() {
        binding.startButton.setOnClickListener {
            startRace()
        }

        binding.stopButton.setOnClickListener {
            coroutine?.cancel()
        }
    }

    private fun startRace() {
        coroutine = lifecycleScope.launch(Dispatchers.Default) {
            while (
                viewModel.redHorseProgress < 100 &&
                viewModel.greenHorseProgress < 100
            ) {
                delay(1500)
                viewModel.greenHorseProgress = viewModel.greenHorseProgress + viewModel.getRandomNumber()
                viewModel.redHorseProgress = viewModel.redHorseProgress + viewModel.getRandomNumber()
                withContext(Dispatchers.Main) {
                    binding.redHorseProgress.progress = viewModel.redHorseProgress
                    binding.greenHorseProgress.progress = viewModel.greenHorseProgress
                }
            }
            withContext(Dispatchers.Main) {
                binding.winnerLabel.text = if(viewModel.redHorseProgress > viewModel.greenHorseProgress) {
                    "O cavalo vermelho venceu!"
                } else if(viewModel.greenHorseProgress > viewModel.redHorseProgress) {
                    "O cavalo verde venceu!"
                } else {
                    "Empate"
                }
            }
        }
    }
}