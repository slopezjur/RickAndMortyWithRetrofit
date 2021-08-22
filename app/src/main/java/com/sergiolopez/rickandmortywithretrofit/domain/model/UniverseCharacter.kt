package com.sergiolopez.rickandmortywithretrofit.domain.model

data class UniverseCharacter(
    val id: Int,
    val name: String,
    val species: String,
    val image: String,
    val page: Int?
)