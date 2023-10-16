package br.com.fiap.marvelapp.shared

import br.com.fiap.marvelapp.BuildConfig
import java.util.Date

object DependencyFactory {

    private const val BASE_URL = "https://gateway.marvel.com:443"

    val timestamp = Date().time.toString()
    val hash = Utils.md5(timestamp + BuildConfig.MARVEL_PRIVATE_KEY + BuildConfig.MARVEL_API_KEY)

}