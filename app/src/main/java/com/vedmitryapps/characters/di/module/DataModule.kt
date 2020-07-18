package com.vedmitryapps.characters.di.module

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.vedmitryapps.characters.data.repository.CharacterRepository
import com.vedmitryapps.characters.data.source.CharacterSource
import com.vedmitryapps.characters.network.api.CharacterApi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    fun provideCharacterSource(characterApi: CharacterApi) : CharacterSource
            = CharacterRepository(characterApi)

    @Provides
    fun provideCharacterApi(httpClient: OkHttpClient) =
        buildRetrofit("https://rickandmortyapi.com/", httpClient)
            .create(CharacterApi::class.java)


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()
    }

    fun buildRetrofit(url: String, httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(httpClient)
            .addConverterFactory(createGsonConverterFactory())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    fun createGsonConverterFactory(): GsonConverterFactory {
        val gson = GsonBuilder()
            .create()
        return GsonConverterFactory.create(gson)
    }
}