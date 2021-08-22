package com.sergiolopez.rickandmortywithretrofit.framework.data.server

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UniverseCharacterResponse(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "image")
    val image: String = "",
    @Json(name = "name")
    val name: String = "",
    @Json(name = "species")
    val species: String = ""
)
