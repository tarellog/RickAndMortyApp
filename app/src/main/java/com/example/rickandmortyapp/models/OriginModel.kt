package com.example.rickandmortyapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class OriginModel(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
) : Parcelable
