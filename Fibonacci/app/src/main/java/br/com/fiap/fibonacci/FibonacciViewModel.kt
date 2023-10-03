package br.com.fiap.fibonacci

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class FibonacciViewModel : ViewModel() {

    var fibonacciIsFinished = MutableLiveData<Int>()

    suspend fun calculateFibonacci(sequenceNumber: Int): Int {
        return withContext(Dispatchers.Default) {
            val result = async {
                delay(5000)
                calculate(sequenceNumber)
            }.await()
            withContext(Dispatchers.Main) {
                fibonacciIsFinished.value = result
            }
            result
        }
    }

    private fun calculate(sequenceNumber: Int) : Int {
        if (sequenceNumber <= 1) {
            return sequenceNumber
        } else {
            return calculate(sequenceNumber - 1) +
                    calculate(sequenceNumber - 2)
        }
    }
}