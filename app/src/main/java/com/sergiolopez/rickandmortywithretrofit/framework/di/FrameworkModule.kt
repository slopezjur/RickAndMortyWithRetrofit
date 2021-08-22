package com.sergiolopez.rickandmortywithretrofit.framework.di

import com.sergiolopez.rickandmortywithretrofit.data.datasources.RemoteDataSource
import com.sergiolopez.rickandmortywithretrofit.framework.data.server.UniverseCharacterApi
import com.sergiolopez.rickandmortywithretrofit.framework.data.server.UniverseCharacterDataSourceServer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FrameworkModule {

    @Provides
    @Singleton
    @Named("baseUrl")
    fun baseUrlProvider(): String = "https://rickandmortyapi.com/api/"

    @Singleton
    @Provides
    fun okHttpClientProvider(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .followRedirects(false)
            .build()
    }

    @Provides
    @Singleton
    fun retrofitProvider(
        @Named("baseUrl") baseUrl: String,
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create().withNullSerialization())
        .client(okHttpClient)
        .baseUrl(baseUrl)
        .build()

    @Provides
    fun remoteDataSourceProvider(retrofit: Retrofit): RemoteDataSource =
        UniverseCharacterDataSourceServer(retrofit.create(UniverseCharacterApi::class.java))
}