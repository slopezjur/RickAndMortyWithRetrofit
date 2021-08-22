package com.sergiolopez.rickandmortywithretrofit.data.repositories

import com.sergiolopez.rickandmortywithretrofit.data.datasources.RemoteDataSource
import com.sergiolopez.rickandmortywithretrofit.domain.model.UniverseCharacter
import com.sergiolopez.rickandmortywithretrofit.domain.repository.UniverseCharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UniverseCharacterRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : UniverseCharacterRepository {

    override fun getUniverseCharacterList(page: Int): Flow<List<UniverseCharacter>> = flow {
        val universeCharacterList = remoteDataSource.getUniverseCharacterList(page)
        emit(universeCharacterList)
    }

    override fun getUniverseCharacter(universeCharacterId: Int): Flow<UniverseCharacter> = flow {
        val universeCharacter = remoteDataSource.getUniverseCharacter(universeCharacterId)

        emit(universeCharacter)
    }
}

