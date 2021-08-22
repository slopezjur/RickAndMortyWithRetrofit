package com.sergiolopez.rickandmortywithretrofit.domain.repository

import com.sergiolopez.rickandmortywithretrofit.domain.model.UniverseCharacter
import kotlinx.coroutines.flow.Flow

interface UniverseCharacterRepository {

    fun getUniverseCharacterList(page: Int): Flow<List<UniverseCharacter>>
    fun getUniverseCharacter(universeCharacterId: Int): Flow<UniverseCharacter>
}
