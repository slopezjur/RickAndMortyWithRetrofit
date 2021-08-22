package com.sergiolopez.rickandmortywithretrofit.usescases

import com.sergiolopez.rickandmortywithretrofit.data.repositories.UniverseCharacterRepositoryImpl
import com.sergiolopez.rickandmortywithretrofit.domain.model.UniverseCharacter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUniverseCharacterList @Inject constructor(
    private val universeCharacterRepositoryImpl: UniverseCharacterRepositoryImpl
) {
    fun load(page: Int): Flow<List<UniverseCharacter>> {
        return universeCharacterRepositoryImpl.getUniverseCharacterList(page)
    }
}