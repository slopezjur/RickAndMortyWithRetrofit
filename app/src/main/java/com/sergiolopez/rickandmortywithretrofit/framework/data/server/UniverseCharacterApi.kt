package com.sergiolopez.rickandmortywithretrofit.framework.data.server

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UniverseCharacterApi {

    @GET("character")
    suspend fun getUniverseCharacterList(
        @Query("page") page: Int
    ): Response<UniverseCharacterListResponse>

    @GET("character/{id}")
    suspend fun getUniverseCharacter(
        @Path("id") characterId: Int
    ): Response<UniverseCharacterResponse>
}