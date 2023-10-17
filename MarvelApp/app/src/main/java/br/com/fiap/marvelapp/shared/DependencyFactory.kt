package br.com.fiap.marvelapp.shared

import br.com.fiap.marvelapp.BuildConfig
import br.com.fiap.marvelapp.data.MarvelRepository
import br.com.fiap.marvelapp.data.MarvelRepositoryImpl
import br.com.fiap.marvelapp.data.MarvelService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Date

object DependencyFactory {

    private const val BASE_URL = "https://gateway.marvel.com:443"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val marvelService: MarvelService = retrofit.create(
        MarvelService::class.java
    )

    val timestamp = Date().time.toString()
    val hash = Utils.md5(timestamp + BuildConfig.MARVEL_PRIVATE_KEY + BuildConfig.MARVEL_API_KEY)

    fun createRepository() : MarvelRepository {
        return MarvelRepositoryImpl(marvelService)
    }
}