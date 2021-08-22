package com.sergiolopez.rickandmortywithretrofit.framework.ui.main

import com.sergiolopez.rickandmortywithretrofit.data.repositories.UniverseCharacterRepositoryImpl
import com.sergiolopez.rickandmortywithretrofit.usescases.GetUniverseCharacterList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class MainActivityModule {

    @Provides
    fun loadCharacterProvider(universeCharacterRepositoryImpl: UniverseCharacterRepositoryImpl) =
        GetUniverseCharacterList(universeCharacterRepositoryImpl)
}