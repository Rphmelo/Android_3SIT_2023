package br.com.fiap.marvelapp.domain

import com.google.gson.annotations.SerializedName

data class MarvelCharacterModel(
    @SerializedName("data")
    val data: MarvelCharacterDataModel
)

data class MarvelCharacterDataModel(
    @SerializedName("results")
    val results: List<MarvelCharacterDataResultModel>
)

data class MarvelCharacterDataResultModel(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("thumbnail")
    val thumbnail: MarvelCharacterDataResultThumbnailModel
) {
    fun getThumbnailFullUrl(): String {
        return "${
            thumbnail.path?.replace(
                "http",
                "https"
            )
        }.${thumbnail.extension}"
    }
}

data class MarvelCharacterDataResultThumbnailModel(
    @SerializedName("path")
    val path: String?,
    @SerializedName("extension")
    val extension: String?
)
