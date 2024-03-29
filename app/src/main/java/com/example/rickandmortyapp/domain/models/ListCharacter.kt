package com.example.rickandmortyapp.domain.models

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import com.example.rickandmortyapp.data.models.LocationCharacterModel
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class ListCharacter(
    val page: Int,
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val location: LocationCharacterModel,
    val image: String,
    val episode: List<String>,
) : Parcelable {

    fun getEpisodeList(): List<Int>{
        val regex = Regex("\\d+")
        return episode.map {
            regex.find(it)?.value.toString().toInt()
        }
    }

}
