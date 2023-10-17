package br.com.fiap.marvelapp.data

import br.com.fiap.marvelapp.domain.MarvelCharacterModel
import retrofit2.Response

interface MarvelRepository {
    suspend fun listCharacters(
        timestamp: String,
        apikey: String,
        hash: String,
        offset: Int
    ): Response<MarvelCharacterModel>
}

class MarvelRepositoryImpl(
    private val service: MarvelService
) : MarvelRepository {

    override suspend fun listCharacters(
        timestamp: String,
        apikey: String,
        hash: String,
        offset: Int
    ): Response<MarvelCharacterModel> {
        return service.listCharacters(
            timestamp,
            apikey,
            hash,
            offset
        )
    }

}