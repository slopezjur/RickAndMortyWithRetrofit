package com.sergiolopez.rickandmortywithretrofit.data.datasources

import com.sergiolopez.rickandmortywithretrofit.domain.model.UniverseCharacter

interface RemoteDataSource {

    suspend fun getUniverseCharacterList(page: Int): List<UniverseCharacter>
    suspend fun getUniverseCharacter(universeCharacterId: Int): UniverseCharacter
}