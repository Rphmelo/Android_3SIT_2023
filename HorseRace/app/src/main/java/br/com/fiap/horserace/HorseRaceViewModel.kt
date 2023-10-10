package br.com.fiap.horserace

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.random.Random

class HorseRaceViewModel : ViewModel() {
    var redHorseProgress = 0
    var greenHorseProgress = 0

    suspend fun getRandomNumber(): Int {
        return withContext(Dispatchers.Default) {
            async {
                Random.nextInt(0, 20)
            }
        }.await()
    }
}