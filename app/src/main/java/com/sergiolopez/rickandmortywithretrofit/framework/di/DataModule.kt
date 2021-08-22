package com.sergiolopez.rickandmortywithretrofit.framework.di

import com.sergiolopez.rickandmortywithretrofit.data.datasources.RemoteDataSource
import com.sergiolopez.rickandmortywithretrofit.data.repositories.UniverseCharacterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun universeCharacterRepositoryProvider(
        remoteDataSource: RemoteDataSource
    ) = UniverseCharacterRepositoryImpl(remoteDataSource)
}