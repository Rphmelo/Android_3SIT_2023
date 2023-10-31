package br.com.fiap.marvelapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.marvelapp.BuildConfig
import br.com.fiap.marvelapp.domain.MarvelCharacterDataResultModel
import br.com.fiap.marvelapp.shared.DependencyFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterListViewModel : ViewModel() {

    val successState = MutableLiveData<List<MarvelCharacterDataResultModel>>()
    val errorState = MutableLiveData<String>()

    suspend fun listCharacters() {
        withContext(Dispatchers.Main) {
            val result = DependencyFactory.createRepository().listCharacters(
                DependencyFactory.timestamp,
                BuildConfig.MARVEL_API_KEY,
                DependencyFactory.hash
            )
            if(result.isSuccessful) {
                result.body()?.data?.results?.let {
                    successState.value = it
                }
            } else {
                errorState.value = "Ocorreu um erro na API da Marvel!"
            }
        }
    }
}