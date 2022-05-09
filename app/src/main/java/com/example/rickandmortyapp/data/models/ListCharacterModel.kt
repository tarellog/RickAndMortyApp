package com.example.rickandmortyapp.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListCharacterModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("origin")
    val origin: OriginModel,
    @SerializedName("location")
    val location: LocationCharacterModel,
    @SerializedName("image")
    val image: String,
    @SerializedName("episode")
    val episode: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
) : Parcelable {

    fun getEpisodeList(): List<Int>{
        val regex = Regex("\\d+")
        return episode.map {
            regex.find(it)?.value.toString().toInt()
        }
    }
}
