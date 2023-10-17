package br.com.fiap.marvelapp.data

import br.com.fiap.marvelapp.domain.MarvelCharacterModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

    @GET("/v1/public/characters")
    suspend fun listCharacters(
        @Query("timestamp") timestamp: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int = 1241
    ) : Response<MarvelCharacterModel>
}