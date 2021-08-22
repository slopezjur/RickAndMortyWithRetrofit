package com.sergiolopez.rickandmortywithretrofit.framework.data.server

import com.sergiolopez.rickandmortywithretrofit.data.datasources.RemoteDataSource
import com.sergiolopez.rickandmortywithretrofit.domain.model.UniverseCharacter

class UniverseCharacterDataSourceServer(
    private val universeCharacterApi: UniverseCharacterApi
) : RemoteDataSource {

    override suspend fun getUniverseCharacterList(page: Int): List<UniverseCharacter> {
        return universeCharacterApi.getUniverseCharacterList(page).run {
            if (isSuccessful) {
                body()?.let { body -> body.results.map { it.toDomain(page) } } ?: emptyList()
            } else {
                emptyList()
            }
        }
    }

    override suspend fun getUniverseCharacter(universeCharacterId: Int): UniverseCharacter {
        return universeCharacterApi.getUniverseCharacter(universeCharacterId).run {
            if (isSuccessful) {
                body()?.toDomain() ?: buildDummyUniverseCharacter()
            } else {
                buildDummyUniverseCharacter()
            }
        }
    }

    private fun UniverseCharacterResponse.toDomain(page: Int? = null) = UniverseCharacter(
        id,
        name,
        species,
        image,
        page,
    )

    private fun buildDummyUniverseCharacter(): UniverseCharacter {
        return UniverseCharacter(0, "", "", "", 0)
    }
}
