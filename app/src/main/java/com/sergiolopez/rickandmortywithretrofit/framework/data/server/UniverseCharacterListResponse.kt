package com.sergiolopez.rickandmortywithretrofit.framework.data.server

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UniverseCharacterListResponse(
    @Json(name = "info")
    val info: Info = Info(),
    @Json(name = "results")
    val results: List<UniverseCharacterResponse> = listOf()
)
